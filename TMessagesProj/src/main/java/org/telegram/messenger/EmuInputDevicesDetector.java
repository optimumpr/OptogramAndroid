package org.telegram.messenger;

import android.os.Build;
import android.text.TextUtils;
import android.view.InputDevice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class EmuInputDevicesDetector {

    private static final String NAME_PREFIX = "N: Name=\"";
    private static final String INPUT_DEVICES_FILE = "/proc/bus/input/devices";
    private static final String[] RESTRICTED_DEVICES = {"bluestacks", "memuhyperv", "virtualbox"};

    private EmuInputDevicesDetector() {
    }

    public static boolean detect() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            for (int id : InputDevice.getDeviceIds()) {
                InputDevice device = InputDevice.getDevice(id);
                if (device != null && matchesEmulatorName(device.getName())) {
                    return true;
                }
            }
            return false;
        }

        final List<String> deviceNames = getInputDevicesNames();
        if (deviceNames != null) {
            for (String deviceName : deviceNames) {
                if (matchesEmulatorName(deviceName)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean matchesEmulatorName(String name) {
        String normalizedName = name.toLowerCase(Locale.ROOT);
        for (String emulatorName : RESTRICTED_DEVICES) {
            if (normalizedName.contains(emulatorName)) {
                return true;
            }
        }
        return false;
    }

    private static List<String> getInputDevicesNames() {
        final File devicesFile = new File(INPUT_DEVICES_FILE);

        if (!devicesFile.canRead()) {
            return null;
        }

        try {
            final List<String> lines = new ArrayList<>();
            final BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(devicesFile)));
            for (String line; (line = r.readLine()) != null; ) {
                if (line.startsWith(NAME_PREFIX)) {
                    final String name = line.substring(NAME_PREFIX.length(), line.length() - 1);
                    if (!TextUtils.isEmpty(name)) {
                        lines.add(name);
                    }
                }
            }
            r.close();
            return lines;
        } catch (IOException e) {
            FileLog.e(e);
            return null;
        }
    }
}
