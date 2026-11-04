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

        return fragmentView;
    }
}
