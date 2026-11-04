package org.telegram.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;

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
        fragmentView = layout;

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

        return fragmentView;
    }
}
