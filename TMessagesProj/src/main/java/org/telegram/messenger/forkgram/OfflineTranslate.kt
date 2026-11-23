package org.telegram.messenger.forkgram

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.os.Looper
import dev.davidv.translator.ITranslationCallback
import dev.davidv.translator.ITranslationService
import dev.davidv.translator.TranslationError
import org.telegram.messenger.AndroidUtilities
import org.telegram.messenger.ApplicationLoader
import org.telegram.messenger.MessagesController
import org.telegram.messenger.Utilities
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

object ForkOfflineTranslate {

    const val PACKAGE = "dev.davidv.translator"
    const val FDROID_URL = "https://f-droid.org/packages/$PACKAGE/"
    private const val ACTION = "dev.davidv.translator.ITranslationService"
    private const val BIND_TIMEOUT_MS = 5000L
    private const val CALL_TIMEOUT_MS = 60000L

    const val PROVIDER_DEFAULT = 0
    const val PROVIDER_ALTERNATIVE = 1
    const val PROVIDER_OFFLINE = 2

    @JvmStatic
    fun provider(): Int =
        MessagesController.getGlobalMainSettings().getInt("translationProvider", PROVIDER_DEFAULT)

    @JvmStatic
    fun method(serverMethod: String?): String? = when (provider()) {
        PROVIDER_ALTERNATIVE -> "alternative"
        PROVIDER_OFFLINE -> "offline"
        else -> serverMethod
    }

    private val bindLock = Any()
    @Volatile private var service: ITranslationService? = null
    private var connection: ServiceConnection? = null
    private var bindLatch: CountDownLatch? = null
    private val strictExecutor by lazy { Executors.newSingleThreadExecutor() }

    @JvmStatic
    fun isAvailable(): Boolean {
        val context = ApplicationLoader.applicationContext ?: return false
        val intent = Intent(ACTION).setPackage(PACKAGE)
        return context.packageManager.resolveService(intent, 0) != null
    }

    @JvmStatic
    fun translateStrictAsync(
        text: String,
        fromLanguage: String?,
        toLanguage: String,
        callback: Utilities.Callback<String?>
    ): Future<*> = strictExecutor.submit(Runnable {
        val result = try {
            if (provider() == PROVIDER_OFFLINE && isAvailable()) {
                translateWithFreshBinding(text, fromLanguage, toLanguage)?.takeIf { it.isNotBlank() }
            } else {
                null
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            return@Runnable
        } catch (e: Exception) {
            null
        }
        AndroidUtilities.runOnUIThread { callback.run(result) }
    })

    private fun translateWithFreshBinding(text: String, fromLanguage: String?, toLanguage: String): String? {
        val context = ApplicationLoader.applicationContext ?: return null
        val ready = CountDownLatch(1)
        val boundService = AtomicReference<ITranslationService?>()
        val binding = object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                boundService.set(ITranslationService.Stub.asInterface(binder))
                ready.countDown()
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                boundService.set(null)
                ready.countDown()
            }

            override fun onBindingDied(name: ComponentName?) = onServiceDisconnected(name)

            override fun onNullBinding(name: ComponentName?) = onServiceDisconnected(name)
        }
        val intent = Intent(ACTION).setPackage(PACKAGE)
        if (!context.bindService(intent, binding, Context.BIND_AUTO_CREATE)) {
            return null
        }
        try {
            if (!ready.await(BIND_TIMEOUT_MS, TimeUnit.MILLISECONDS) || provider() != PROVIDER_OFFLINE
                || Thread.currentThread().isInterrupted) {
                return null
            }
            val bound = boundService.get() ?: return null
            return requestTranslation(bound, text, fromLanguage, toLanguage)
        } finally {
            context.unbindService(binding)
        }
    }

    @JvmStatic
    fun translate(text: String, fromLanguage: String?, toLanguage: String): String? {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null
        }
        val bound = ensureService() ?: return null
        return try {
            requestTranslation(bound, text, fromLanguage, toLanguage)
        } catch (e: InterruptedException) {
            throw e
        } catch (e: Exception) {
            service = null
            null
        }
    }

    private fun requestTranslation(
        bound: ITranslationService, text: String, fromLanguage: String?, toLanguage: String
    ): String? {
        val resultRef = AtomicReference<String?>(null)
        val latch = CountDownLatch(1)
        val callback = object : ITranslationCallback.Stub() {
            override fun onTranslationResult(translatedText: String?) {
                resultRef.set(translatedText)
                latch.countDown()
            }

            override fun onTranslationError(error: TranslationError?) {
                latch.countDown()
            }
        }
        bound.translate(text, fromLanguage ?: "", toLanguage, callback)
        return if (latch.await(CALL_TIMEOUT_MS, TimeUnit.MILLISECONDS)) resultRef.get() else null
    }

    private fun ensureService(): ITranslationService? {
        service?.let { return it }
        val context = ApplicationLoader.applicationContext ?: return null
        synchronized(bindLock) {
            service?.let { return it }
            var latch = bindLatch
            if (connection == null) {
                latch = CountDownLatch(1)
                val awaiting = latch
                val conn = object : ServiceConnection {
                    override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
                        service = ITranslationService.Stub.asInterface(binder)
                        awaiting.countDown()
                    }

                    override fun onServiceDisconnected(name: ComponentName?) {
                        service = null
                    }
                }
                val intent = Intent(ACTION).setPackage(PACKAGE)
                val ok = try {
                    context.bindService(intent, conn, Context.BIND_AUTO_CREATE)
                } catch (e: Exception) {
                    false
                }
                if (!ok) {
                    try {
                        context.unbindService(conn)
                    } catch (ignore: Exception) {
                    }
                    return null
                }
                connection = conn
                bindLatch = latch
            }
            latch?.await(BIND_TIMEOUT_MS, TimeUnit.MILLISECONDS)
            return service
        }
    }
}
