package org.telegram.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.telegram.messenger.MessagesController;
import org.telegram.messenger.NotificationCenter;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.ActionBar;
import org.telegram.ui.ActionBar.BaseFragment;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Cells.TextCheckCell;
import org.telegram.ui.Cells.TextInfoPrivacyCell;
import org.telegram.ui.Components.LayoutHelper;

/**
 * Optogram-specific preferences. Only expose settings whose backing behavior
 * has been verified against the current Forkgram baseline.
 */
public class OptogramSettingsActivity extends BaseFragment {
    private static final String LOCAL_PREMIUM = "localPremium";

    @Override
    public View createView(Context context) {
        actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        actionBar.setAllowOverlayTitle(true);
        actionBar.setTitle("Optogram Settings");
        actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() {
            @Override
            public void onItemClick(int id) {
                if (id == -1) {
                    finishFragment();
                }
            }
        });

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        ScrollView scrollView = new ScrollView(context);
        scrollView.setFillViewport(true);
        scrollView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        scrollView.addView(layout);
        fragmentView = scrollView;

        SharedPreferences preferences = MessagesController.getGlobalMainSettings();
        TextCheckCell localPremiumCell = new TextCheckCell(context);
        localPremiumCell.setTextAndCheck(
                "Local Premium",
                preferences.getBoolean(LOCAL_PREMIUM, false),
                false
        );
        layout.addView(localPremiumCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        localPremiumCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean(LOCAL_PREMIUM, false);
            preferences.edit().putBoolean(LOCAL_PREMIUM, enabled).apply();
            localPremiumCell.setChecked(enabled);
            NotificationCenter.getGlobalInstance().postNotificationName(
                    NotificationCenter.premiumStatusChangedGlobal);
        });

        TextInfoPrivacyCell information = new TextInfoPrivacyCell(context);
        information.setText(
                "Enables supported local interface features, including Premium launcher icons. "
                + "This does not change Telegram server-side Premium status or unlock "
                + "subscription-only server features.");
        layout.addView(information, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        TextCheckCell deviceInfoCell = new TextCheckCell(context);
        deviceInfoCell.setTextAndCheck(
                "Hide Device Information",
                preferences.getBoolean("disableDeviceInfo", false),
                false);
        layout.addView(deviceInfoCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        deviceInfoCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableDeviceInfo", false);
            preferences.edit().putBoolean("disableDeviceInfo", enabled).apply();
            deviceInfoCell.setChecked(enabled);
        });

        TextInfoPrivacyCell deviceInfoDescription = new TextInfoPrivacyCell(context);
        deviceInfoDescription.setText(
                "Reports Unknown instead of the device model and Android version "
                + "when initializing Telegram connections. Restart Optogram after changing this setting.");
        layout.addView(deviceInfoDescription, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));


        TextCheckCell webLoginCell = new TextCheckCell(context);
        webLoginCell.setTextAndCheck(
                "Disable Automatic Web Login",
                preferences.getBoolean("disableAutowebLogin", false),
                false);
        layout.addView(webLoginCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        webLoginCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableAutowebLogin", false);
            preferences.edit().putBoolean("disableAutowebLogin", enabled).apply();
            webLoginCell.setChecked(enabled);
        });

        TextInfoPrivacyCell webLoginDescription = new TextInfoPrivacyCell(context);
        webLoginDescription.setText(
                "Prevents automatic login tokens from being appended to links for Telegram-approved domains.");
        layout.addView(webLoginDescription, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));

        TextCheckCell botOpenCell = new TextCheckCell(context);
        botOpenCell.setTextAndCheck(
                "Disable Open Bot Button",
                preferences.getBoolean("disableOpenBotButton", false),
                false);
        layout.addView(botOpenCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        botOpenCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableOpenBotButton", false);
            preferences.edit().putBoolean("disableOpenBotButton", enabled).apply();
            botOpenCell.setChecked(enabled);
        });

        TextCheckCell webGeolocationCell = new TextCheckCell(context);
        webGeolocationCell.setTextAndCheck(
                "Disable WebView Geolocation",
                preferences.getBoolean("disableWebViewGeolocation", true),
                false);
        layout.addView(webGeolocationCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        webGeolocationCell.setOnClickListener(v -> {
            boolean disabled = !preferences.getBoolean("disableWebViewGeolocation", true);
            preferences.edit().putBoolean("disableWebViewGeolocation", disabled).apply();
            webGeolocationCell.setChecked(disabled);
        });

        TextInfoPrivacyCell webGeolocationDescription = new TextInfoPrivacyCell(context);
        webGeolocationDescription.setText(
                "Blocks geolocation requests from newly opened embedded bot webviews unless you enable them.");
        layout.addView(webGeolocationDescription, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));

        TextCheckCell birthdayReminderCell = new TextCheckCell(context);
        birthdayReminderCell.setTextAndCheck(
                "Disable Birthday Reminder",
                preferences.getBoolean("disableBirthdayReminder", false),
                false);
        layout.addView(birthdayReminderCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        birthdayReminderCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableBirthdayReminder", false);
            preferences.edit().putBoolean("disableBirthdayReminder", enabled).apply();
            birthdayReminderCell.setChecked(enabled);
        });

        TextCheckCell disablePromoCell = new TextCheckCell(context);
        disablePromoCell.setTextAndCheck(
                "Disable Birthday Setup Promotion",
                preferences.getBoolean("disablePromo", false),
                false);
        layout.addView(disablePromoCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        disablePromoCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disablePromo", false);
            preferences.edit().putBoolean("disablePromo", enabled).apply();
            disablePromoCell.setChecked(enabled);
        });


        TextCheckCell hidePhoneCell = new TextCheckCell(context);
        hidePhoneCell.setTextAndCheck(
                "Hide Phone Number in Profiles",
                preferences.getBoolean("hidePhoneNumber", false),
                false);
        layout.addView(hidePhoneCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        hidePhoneCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("hidePhoneNumber", false);
            preferences.edit().putBoolean("hidePhoneNumber", enabled).apply();
            hidePhoneCell.setChecked(enabled);
        });


        TextCheckCell archivePullCell = new TextCheckCell(context);
        archivePullCell.setTextAndCheck(
                "Open Archive on Pull",
                preferences.getBoolean("openArchiveOnPull", true),
                false);
        layout.addView(archivePullCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        archivePullCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("openArchiveOnPull", true);
            preferences.edit().putBoolean("openArchiveOnPull", enabled).apply();
            archivePullCell.setChecked(enabled);
        });

        TextCheckCell hideArchiveStoriesCell = new TextCheckCell(context);
        hideArchiveStoriesCell.setTextAndCheck(
                "Hide Stories in Archive",
                preferences.getBoolean("hideStoriesInArchive", false),
                false);
        layout.addView(hideArchiveStoriesCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        hideArchiveStoriesCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("hideStoriesInArchive", false);
            preferences.edit().putBoolean("hideStoriesInArchive", enabled).apply();
            hideArchiveStoriesCell.setChecked(enabled);
        });


        TextCheckCell disableAutoPlayCell = new TextCheckCell(context);
        disableAutoPlayCell.setTextAndCheck(
                "Disable Auto Play Next Message",
                preferences.getBoolean("disableAutoPlayNextMessage", false),
                false);
        layout.addView(disableAutoPlayCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        disableAutoPlayCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableAutoPlayNextMessage", false);
            preferences.edit().putBoolean("disableAutoPlayNextMessage", enabled).apply();
            disableAutoPlayCell.setChecked(enabled);
        });


        TextCheckCell recentFilesCell = new TextCheckCell(context);
        recentFilesCell.setTextAndCheck(
                "Disable Recent Files in Attachments",
                preferences.getBoolean("disableRecentFilesAttachment", false),
                false);
        layout.addView(recentFilesCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        recentFilesCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableRecentFilesAttachment", false);
            preferences.edit().putBoolean("disableRecentFilesAttachment", enabled).apply();
            recentFilesCell.setChecked(enabled);
        });


        TextCheckCell botLinkParametersCell = new TextCheckCell(context);
        botLinkParametersCell.setTextAndCheck(
                "Disable Parameters From Bot Links",
                preferences.getBoolean("disableParametersFromBotLinks", false),
                false);
        layout.addView(botLinkParametersCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        botLinkParametersCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableParametersFromBotLinks", false);
            preferences.edit().putBoolean("disableParametersFromBotLinks", enabled).apply();
            botLinkParametersCell.setChecked(enabled);
        });


        TextCheckCell disableDialogThumbnailsCell = new TextCheckCell(context);
        disableDialogThumbnailsCell.setTextAndCheck(
                "Disable Thumbnails in Dialog List",
                preferences.getBoolean("disableThumbsInDialogList", false),
                false);
        layout.addView(disableDialogThumbnailsCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        disableDialogThumbnailsCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableThumbsInDialogList", false);
            preferences.edit().putBoolean("disableThumbsInDialogList", enabled).apply();
            disableDialogThumbnailsCell.setChecked(enabled);
        });

        TextCheckCell lastSeenDotsCell = new TextCheckCell(context);
        lastSeenDotsCell.setTextAndCheck(
                "Enable Last Seen Colored Dots",
                preferences.getBoolean("enableLastSeenDots", true),
                false);
        layout.addView(lastSeenDotsCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        lastSeenDotsCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("enableLastSeenDots", true);
            preferences.edit().putBoolean("enableLastSeenDots", enabled).apply();
            lastSeenDotsCell.setChecked(enabled);
        });


        TextCheckCell disableAdsCell = new TextCheckCell(context);
        disableAdsCell.setTextAndCheck(
                "Hide Sponsored Messages",
                preferences.getBoolean("disableAds", true),
                false);
        layout.addView(disableAdsCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        disableAdsCell.setOnClickListener(v -> {
            boolean enabled = !preferences.getBoolean("disableAds", true);
            preferences.edit().putBoolean("disableAds", enabled).apply();
            disableAdsCell.setChecked(enabled);
        });

        return fragmentView;
    }
}
