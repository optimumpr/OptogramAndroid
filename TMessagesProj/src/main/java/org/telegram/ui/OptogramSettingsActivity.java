package org.telegram.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import org.telegram.messenger.BirthdayController;
import org.telegram.messenger.MessagesController;
import org.telegram.messenger.UserConfig;
import org.telegram.ui.ActionBar.AlertDialog;
import org.telegram.ui.Cells.TextCell;
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


        TextCell diagnosticCell = new TextCell(context);
        diagnosticCell.setText("Birthday Reminder Diagnostics", false);
        layout.addView(diagnosticCell, LayoutHelper.createLinear(
                LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        diagnosticCell.setOnClickListener(v -> {
            boolean remindersDisabled = preferences.getBoolean("disableBirthdayReminder", false);
            boolean setupDisabled = preferences.getBoolean("disablePromo", false);
            boolean birthdaysToday = BirthdayController.getInstance(currentAccount).contains();
            MessagesController controller = MessagesController.getInstance(currentAccount);
            boolean setupSuggested = controller.pendingSuggestions.contains("BIRTHDAY_SETUP");
            boolean hasBirthday = controller.getUserFull(UserConfig.getInstance(currentAccount).getClientUserId()) != null
                    && controller.getUserFull(UserConfig.getInstance(currentAccount).getClientUserId()).birthday != null;
            boolean reminderAllowed = DialogsActivity.isOptogramBirthdayHintAllowed(remindersDisabled);
            boolean setupAllowed = DialogsActivity.isOptogramBirthdayHintAllowed(setupDisabled);
            boolean gateTestPassed = !DialogsActivity.isOptogramBirthdayHintAllowed(true)
                    && DialogsActivity.isOptogramBirthdayHintAllowed(false);
            String report = "Today\u0027s birthdays available: " + birthdaysToday
                    + "\\nBirthday reminder disabled: " + remindersDisabled
                    + "\\nBirthday reminder gate: " + (reminderAllowed ? "ALLOW" : "SUPPRESS")
                    + "\\n\\nBirthday setup suggested: " + setupSuggested
                    + "\\nBirthday already configured: " + hasBirthday
                    + "\\nBirthday setup disabled: " + setupDisabled
                    + "\\nBirthday setup gate: " + (setupAllowed ? "ALLOW" : "SUPPRESS")
                    + "\\n\\nSynthetic gate test (enabled and disabled): " + (gateTestPassed ? "PASS" : "FAIL")
                    + "\\n\\nThis checks the same preference gates used by the chat-list banners. It does not create birthdays, request suggestions, or prove that a banner would otherwise appear.";
            showDialog(new AlertDialog.Builder(context)
                    .setTitle("Birthday Reminder Diagnostics")
                    .setMessage(report)
                    .setPositiveButton("OK", null)
                    .create());
        });

        return fragmentView;
    }
}
