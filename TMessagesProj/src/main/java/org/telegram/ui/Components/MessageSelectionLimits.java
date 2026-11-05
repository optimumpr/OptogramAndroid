package org.telegram.ui.Components;

import org.telegram.messenger.LocaleController;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

public final class MessageSelectionLimits {
    public static final int MAX_SELECTED_MESSAGES = 200;
    // Preserve the previous UI bound for operations whose larger batches are unverified.
    public static final int LEGACY_BULK_LIMIT = 100;

    private MessageSelectionLimits() {
    }

    public static boolean canAdd(int selected, int additional, int limit) {
        return additional <= limit - selected;
    }

    public static void showSelectionLimit(BaseFragment fragment, int limit) {
        BulletinFactory.of(fragment).createErrorBulletin(
                LocaleController.formatString(R.string.OptogramMessageSelectionLimit, limit)).show();
    }

    public static boolean allowLegacyBulkAction(BaseFragment fragment, int selected) {
        if (selected <= LEGACY_BULK_LIMIT) {
            return true;
        }
        BulletinFactory.of(fragment).createErrorBulletin(
                LocaleController.formatString(R.string.OptogramMessageBulkActionLimit, LEGACY_BULK_LIMIT)).show();
        return false;
    }
}
