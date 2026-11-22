# Optogram chronological integration

## Sequence

Use the original Optogram first-parent history after Forkgram 12.4.2
(`b55b00680`) through `optogram-security-2026-11-02^{commit}` (`d041fcba2`).
After the original lineage ends at `d041fcba2`, continue with the first-parent
Optogram 13.1.1 port on `main` starting at `a5ad8d6ff`. Use
`integration/optogram-forkgram-base` to cross-check subsequent fixes. Compare product behavior and file paths when matching
ports to their original commits. The Telegram-based experiment also contains
alternate ports.

List the original sequence with
`git log --first-parent --reverse --oneline b55b00680..d041fcba2`.
Prior 13.2.4 audits and commits supply equivalence evidence where applicable.

## Batch 1

Baseline `fc31ed760`. Examined `9baa26817` through `bd1c5e7d6` inclusive.
Four integrated, eight skipped, and twelve deferred. Resume with
`b5283d54d` (Show joined date in menu, commit by tehcneko).

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `9baa26817` | Revert "Added option for interval of updates check." | DEFERRED | The update interval still has a live row in the unified settings. Review with updater removal as one change. |
| `64866563c` | Revert "Added Forkgram icon to list of devices." | SKIPPED | This upstream revert also removes Desktop icon classification. Keep the newer SessionCell and SessionBottomSheet mappings for remote clients. |
| `89a4fcb84` | Revert "Added new button to settings to check updates." | DEFERRED | The historical settings update entry is part of the updater retirement. Review current settings, search, and debug entry points together. |
| `8457f2523` | Revert | DEFERRED | The original updater removal mixes CI, build constants, and download infrastructure. Start with the later scoped removal sequence ending at cd38138f0, and review current automatic checks and download ownership. |
| `7f6a745ae` | Revert "Changed book_logo icon." | SKIPPED | The book logo rollback was an intermediate asset state, superseded by 98bab246a. |
| `d57a9b0ed` | Revert "Replaced default app icon with Forkgram icon." | DEFERRED | The old default-icon rollback changes manifest aliases and removes selectable icons. Compare the later Default and Adaptive restoration against the current alias and launcher settings model. |
| `21a028336` | Revert "Replaced launcher icons with Forkgram icons." | SKIPPED | The intermediate ic_launcher_dr rollback was superseded by 98bab246a and later artwork changes. |
| `db149d88b` | Revert "Added new Forkgram icons." | DEFERRED | Removing the old icon pack wholesale would affect selectable icons and stored launcher choices. Review the final artwork by alias and flavor. |
| `08d11bdcb` | Add option to disable ads | SKIPPED | Sponsored suppression and its unified setting are present through e020480e2 and 66c7ec2fc. |
| `98bab246a` | Replace icons and some strings | DEFERRED | Review surviving book_logo and developer-release artwork as part of the final asset set. The old strings include wording and settings behavior that changed later. |
| `63ce4d4ea` | Option to add Local Premium | SKIPPED | The original patch changes entitlement checks. Keep the current local Premium behavior under the batch constraints. |
| `dce602cc4` | Change some icons | DEFERRED | Older default launcher PNGs need to be reconciled with the later Telegram artwork restoration and the current adaptive aliases. Batch 3 reviewed 0265c9ca9 and c6fff4052 and carried the artwork reconciliation forward. |
| `9639cbb69` | Make it build | DEFERRED | The settings title and app identity are represented. The mixed build workaround removes browser preferences and changes DNS, signing, variants, and Premium. Review any surviving de-Googling gaps separately against the latest build. |
| `1123c395a` | Change some more icons | DEFERRED | The intro logo and launcher PNGs need comparison with the later art and intro changes for each active flavor. |
| `d88e8ff7d` | Some branding changes | INTEGRATED | Apply the final display-name behavior from 552b08cfe and update existing localized name overrides. The chat title and settings entry are already branded. Defer icon mappings and diagnostic wording to the appropriate follow-ups. |
| `445094d84` | Add wav and wav_x support, based on commit by Attorelle | DEFERRED | WAV document recognition is already present through d2d2ce007. The legacy ExoPlayer classes are absent and the current build uses Media3. Decoder capability for x-wav and the active FFmpeg configuration still need verification. |
| `801611b26` | Change app id | SKIPPED | 9c55abd6b already sets the Optogram application ID for the primary build. Keep newer flavor identities and signing behavior. |
| `28555ec88` | Modify some icons | DEFERRED | The intro and numbered launcher images overlap later art edits. Review the final artwork per density and alias before replacing assets. |
| `92cd90726` | Option to autolock the app immediately | DEFERRED | The setting remains absent. Review the later split port 1fa893219, 79f5a0308, 30ac0f4b2, and cb2193038 against current passcode lifecycle and multi-window behavior as one unit. |
| `7730b5284` | Do not save qr login state | SKIPPED | Explicitly reversed by f0c897424. Preserve current QR login state handling. |
| `97f3ca747` | Change background color | INTEGRATED | Apply the final darker gradient from 3bc748250 to the current standalone icon background resource. |
| `f0c897424` | Revert "Do not save qr login state" | SKIPPED | Reverses 7730b5284. Neither change is needed to preserve the existing QR login state path. |
| `2865d363a` | Change some more background colors | INTEGRATED | The four standalone icon gradient resources still matched the older patch base. Apply the historical colors directly. |
| `bd1c5e7d6` | More background colors | INTEGRATED | The four night widget nine-patch resources still matched the older patch base. Apply the historical binary patch directly. |

## Batch 2

Baseline `715cdcd0b`. Examined `b5283d54d` through `a557449fd` inclusive.
Six integrated, twelve skipped, and seven deferred. Resume with
`bf941a730` (Revert "Replaced frequent contacts with logged in accounts in App Shortcuts.").

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `b5283d54d` | Show joined date in menu, commit by tehcneko | INTEGRATED | Use the final menu corrections from 7be3e6549, 4dcd7466c, and 5c18722ef as the basis for the profile menu. Also restore the date in the member-management menu. The cache now keeps the serialized server date while retaining SQL ordering by the local timestamp. |
| `bd9a412f8` | Miscellaneous | DEFERRED | Old store descriptions mix branding with an outdated feature list. Update publishable metadata against current behavior and distribution separately. |
| `b0a807898` | Change some strings | INTEGRATED | Use the current branded app name in the Settings section header. Keep current settings copy and sentence casing. |
| `f6b4787ea` | Change more strings | INTEGRATED | Use the current branded app name in the alternate profile settings section header. Shares the Settings branding commit. |
| `f57b4b332` | Change more strings | SKIPPED | Historical title-case changes leave current custom-title, chat prompt, send-as, and emoji behaviors intact. Keep the newer wording. |
| `16ca13adb` | Improve default sync contacts to false | SKIPPED | 338a07ef1 already defaults sync off, including login state restore. Current UserConfig also defaults and clears it to false. The original patch precedes the first-login correction 1ca6a2e06, confirmed equivalent in Batch 4. |
| `a593a66b0` | Revert "Disabled new passkeys." | SKIPPED | Intermediate passkey reversal superseded by ada4ca510 and the current disabled capability. |
| `c00e9757c` | Revert "Added duration info in Shared Voices tab." | SKIPPED | The old reversal targets legacy SharedAudioCell formatting. Keep newer voice captions and metadata layouts. |
| `5a017c6d3` | Revert "Changed notification icon." | DEFERRED | The historical reversal restores older notification PNGs. Reconcile the active notification, launcher, and flavor assets before replacing any artwork from the newer base. |
| `ada4ca510` | Restore disable passkeys | SKIPPED | Current BuildVars capability and setup gates already disable passkeys. The old activity-specific patch is unnecessary. |
| `243e5f70c` | Remove LastFM | DEFERRED | Last.fm still exists in current settings and playback. Its historical removal spans CI, credentials, preferences, playback callbacks, and UI. Review as a cohesive feature retirement. |
| `643fda950` | Increase message selection to 200 | DEFERRED | Both chat and shared-media selection still cap at 100. Keep the previous audit decision pending verification of deletion and other unchunked bulk requests. |
| `3a9dd2c39` | Up version | SKIPPED | Obsolete 12.4.2 version update. Keep the 13.2.4 build version. |
| `ba7a62ad3` | Update gitignore | SKIPPED | Ignoring all Gradle properties is obsolete under current tracked configuration and local credential files. |
| `1f84b0b50` | Update README | SKIPPED | The historical full README rewrite would remove current build and distribution guidance and make claims that need verification. |
| `dc5a9691e` | Update gitignore | SKIPPED | Removing tracked Gradle defaults is obsolete under the newer signing and local configuration model. Related to ba7a62ad3 and 2da084874. |
| `b7528e7cb` | Toggle to hide keyboard on chat scrolling | INTEGRATED | Restore the opt-in setting in the unified Optogram screen using the original preference key. Dismiss only on manual chat dragging. Use the later placement from f6468321f as a guide. |
| `2da084874` | Sample gradle properties | SKIPPED | Historical example superseded by the current local properties and signing setup. Keep obsolete credential configuration out of the repository. |
| `4e53491dd` | update Readme | SKIPPED | Credit-line follow-up to the historical README rewrite. Revisit attribution only in a current documentation update. |
| `82bf42cd5` | View Stats in Message Menu, commit by @immat0x1 | INTEGRATED | Reuse the existing statistics handler with the final eligibility from 3355f8223 and 99722a785. Separate poll statistics and exclude ephemeral and ineligible posts. |
| `644f8d532` | Darken some backgrounds | DEFERRED | The gradient was already restored using the final colors through 49702b3ac. The badge still used by PickerBottomLayoutViewer has a newer xxhdpi asset. Treat the density family as a set and inspect nine-patch behavior before replacing it. |
| `e22106d34` | Darken some backgrounds | INTEGRATED | Both Android style overlays still used the original blue values. Apply the matching gray theme colors. |
| `7398d11e7` | Update Readme | SKIPPED | Old README and screenshot advertise 200-message selection and other historical states. Keep the current feature and release documentation. |
| `45c60f861` | Reset disconnect timeout on successful connection, commit by @tehcneko | DEFERRED | Native reconnect and Java app-config refresh behavior both need review. The later 650332534 covers only the native timeout reset. Check current retry and lifecycle behavior before importing either part. Batch 3 related this to d60bd9b51 and 4dc4c401e through the shared recovery path. All three remain deferred. |
| `a557449fd` | fix some crashes | DEFERRED | The original leftBaseline change targets the old tablet initialization. Current code has a context guard, a cached tablet mode, and a user override. Revisit with a reproducible startup or layout failure. |

## Batch 3

Baseline `7071ab713`. Examined `bf941a730` through `228521f4e` inclusive.
7 integrated, 11 skipped, and 12 deferred.
Resume with `6c7c51c29` (Spoof as  Windows when OEM device model is disabled).

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `bf941a730` | Revert "Replaced frequent contacts with logged in accounts in App Shortcuts." | SKIPPED | Current MediaDataController combines visible-account and opt-in contact shortcuts, caps the latter after reserving account slots, and suppresses them behind passcode or hidden-account gates. The old replacement would remove newer shortcut behavior. |
| `af0854279` | some fixes | DEFERRED | Search, gift, direct and broadcast-group info already have current content descriptions. Audit the newer Recent Actions info button label separately. Old index-based labels do not fit current buttons. |
| `0861de9d6` | some more fixes | DEFERRED | The grouped high-quality photo part is already handled by ca5d3e6e3. The bitmap part needs decode-failure handling and alias checks in rebuildPhoto because a crop or transform can fail or retain its source. |
| `66c4e842b` | Add media resolution to details, commit @tehcneko | SKIPPED | Despite the title, the diff forces ShareAlert dark-theme geometry in light mode. It adds no resolution metadata and targets old picker layout behavior. |
| `bfe15bbf8` | Revert "Removed debug button from settings." | SKIPPED | The historical revert restores a debug section header. Current profile has its own developer menu path. Keep its visibility and existing updater deferrals. |
| `9e653f838` | Revert "Added ability to copy Username without long touch." | SKIPPED | Current ProfileActivity has explicit copy-username menu and row handlers. Keep the newer interaction paths. |
| `6d78d4974` | More dark backgrounds | INTEGRATED | Apply the three matching splash logo drawable background changes. No launcher alias or artwork replacement. |
| `144907372` | Disable contact phone number sharing prompt, commit by @cinitdev | INTEGRATED | Follow 94852d650 and 3340672ec for the corrected negated preference and one unified setting. Manual contact sharing is unchanged. |
| `d93a44db4` | Remove video quality limitation in Stories, commit by @omg-xtao | INTEGRATED | Expose the existing story quality selector for non-Premium accounts and let the preference choose between the received primary and alternative documents. Keep the outer story eligibility and existing server requests. |
| `220cdddb3` | Remove some restrictions | DEFERRED | Mixed local Premium gates in file transfer, account/request handling, effects, and UI. Some expressions require both real and local Premium, others use either. Reconcile with 9a3f784be and the later Miscellaneous series per call site, with client UI and request effects tracked separately. Batch 4 restored the launcher selector behavior using the later final selector correction. Broader gates remain deferred. |
| `bf272f005` | Remove some more restrictions | DEFERRED | Mixed local Premium changes across captions, forwarding, stickers, translation, transcription, and topic flows. Trace limits and request construction against current implementations, including newer voice and translation options. |
| `ec05798ef` | And some more restrictions | DEFERRED | Mixed changes in mentions, folder tags, downloads, peer colors, and stories. Revisit with the later targeted Miscellaneous fixes. Preserve each original scope independently of server acceptance. |
| `ae60ebfde` | Tell user if message is from Channeln | INTEGRATED | Use 868489e24 and be15c8afb in the current megagroup header, preserving earlier tag precedence. Exclude the unrelated historical Debian package. |
| `2eda2c23e` | Fix NPE | SKIPPED | Already covered by ecfbb6294 using the current SimpleActionBar. |
| `1976d2896` | V23.4.3.0 | SKIPPED | Forkgram already handles bot-forum row updates through checkRemoveBotForumRowsStartThreadRow(boolean) and has newer sticker/topic implementations. Exclude the historical bottom-overlay modification and compiler log. |
| `c0f5e6590` | Tell user if message is from Bot | INTEGRATED | Use 298f3b726 and b3f18d742 to add the bot attribution fallback to the same megagroup header. |
| `0bec92872` | Fix NPE | DEFERRED | Legacy ExoPlayer paths no longer exist. Map the audio and video buffer null cases to the active Media3 module and confirm JNI ownership before porting. Exclude the compiler log. |
| `ccdb3c2c3` | add multi share, commit by @dic1911 | DEFERRED | PhotoViewer currently shares the selected item and newer share ingress handles multiple items. The historical viewer chooser still needs a port that validates all album members, file readiness, protected content, and URI grants. Existing grouped sending is separate. |
| `eff4d8268` | Fix sharing web links | SKIPPED | LaunchActivity already combines a subject with incoming HTTP(S) text shares, the behavior also carried by 6e7c2efe0. |
| `c8305e930` | Some more changes | DEFERRED | Poll editor gates and emoji tab changes are mixed with a local Premium predicate change. Compare poll entity serialization and newer poll restrictions before adopting the intended per-context behavior. |
| `d60bd9b51` | Disable Use_Delegate_Host_Resolve to prevent using Google servers, commit by @Timothy Redaelli | DEFERRED | USE_DELEGATE_HOST_RESOLVE is still defined. Review the final system DNS changes with current native and Java WebSocket fallback together, including the earlier deferred reconnect fix. |
| `4dc4c401e` | Replace Google dns with Adguard | DEFERRED | Current Java resolver still contains Google endpoints. Historical replacement was followed by several resolver changes, including 2741e4750 and d78008446. Trace active per-flavor lookup and recovery paths before adapting final non-Google behavior. |
| `681288265` | Disable geo location for  webview | SKIPPED | Default WebView geolocation denial and explicit opt-in already exist through badf97380 and 9c58060f6. |
| `0265c9ca9` | Edit some launcher icons | DEFERRED | The final dark standalone gradient is already in 49702b3ac. Numbered launcher foregrounds need the open density, alias, and flavor reconciliation from Batch 1. |
| `c6fff4052` | Edit some more launcher icons | DEFERRED | This changes the standalone adaptive foreground and the controller mapping together. Reconcile with the later adaptive icon commits before replacing any alias resources. |
| `de5c5f7da` | Toggle to disable Premium Promo | SKIPPED | Current hidePremiumSpeedPromo setting and dialog-search gate already implement the corrected behavior from b440adabb. The original condition was inverted. |
| `25e447fd9` | Toggle to disable AutoPlay of Next Audio Message | INTEGRATED | Reuse the original preference key and an independent unified music setting. Reuse current end-of-playlist cleanup on automatic end so the player is released and the playlist position is retained. Manual navigation and Forkgram voice autoplay remain independent. |
| `25a01d2c7` | Toggle to disable Birthday Reminders | SKIPPED | Current disableBirthdayReminder row and BIRTHDAY_CONTACTS_TODAY gate already implement the corrected behavior. |
| `6fdfb924d` | Fix possible crash, commit by @23rd | SKIPPED | MainTabsActivity already has the same tabsView and updateLayoutWrapper null guard. |
| `228521f4e` | Give user choice to enable or disable device OEM information shown in Settings-Devices | INTEGRATED | Use the later 13.1.1 conditional masking behavior from 34b6b7d52 and the unified control from a418c19a5. Java values pass through native_init to initConnection device_model and system_version serialization. Mask copied profile diagnostics with the same preference. Batch 4 integrated the current-session presentation from 6c7c51c29 and 6de198c33 and retained this later conditional wire behavior. Verify Telegram Desktop after restart. |

## Batch 4

Baseline `8158ddc8d`. Examined `6c7c51c29` through `5b500b31f` inclusive.
9 integrated, 14 skipped, and 7 deferred.
Resume with `f536c4a72` (Miscellaneous5).

The launcher-only Local Premium setting uses the original preference and the
later selector correction `1a2d3ce41`. This advances the isolated launcher slice
of the deferred Local Premium work. Batch 5 integrated the remaining `f536c4a72` surfaces in LogoutActivity and UserInfoActivity. Updater retirement, Media3 WAV decoder support,
DNS and reconnect, and launcher pack reconciliation remain open.

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `6c7c51c29` | Spoof as  Windows when OEM device model is disabled | INTEGRATED | Restore the Windows icon and animation for the current masked session. Original diff only changed Android icon branches, with no protocol changes. Keep unrelated devices truthful. |
| `ca723638e` | Refactor optogram settings look | INTEGRATED | Restore the Jaguar settings tile using the final asset from c2cb1df43 and later port 536db3030. Keep the unified screen and current row ID. |
| `a6874e946` | Remove sdk version | SKIPPED | Conditional Unknown/SDK masking is already implemented at connection startup. 6de198c33 briefly made the SDK unconditional; the later 34b6b7d52 port restores the current conditional behavior. |
| `6de198c33` | Refactor device info hiding | INTEGRATED | Mask the displayed current-session device label alongside the local Windows icon. Retain the final port's conditional SDK masking, real app version, server-reported platform metadata, and separate CDN placeholders. Do not relabel other sessions. |
| `28004bfb2` | Update Readme | SKIPPED | Historical README lists Google DNS replacement that is still deferred. Keep current documentation pending verified behavior. |
| `7be1befac` | Provide link to Optogram releases | SKIPPED | Historical release channel link refers to an older distribution setup. Keep the current release guidance. |
| `41cd7725f` | Update Readme | SKIPPED | Historical push-provider wording and credits follow the old README rewrite. Preserve current provider setup documentation. |
| `9beb5107b` | fix: text input value UI oerflow, commit by @dic1911 | DEFERRED | Current TextSettingsCell uses AnimatedTextView with AT_MOST measurement and a new layout path. Confirm clipping on narrow screens before adapting. The old character-count truncation can generate invalid substring bounds. |
| `27dbf82f6` | fix: Fix missing open linked channel, commit by @tehcneko | SKIPPED | The legacy linked-channel menu insertion was explicitly reverted by 96aaad414. |
| `e9e853045` | fix: Fix id text overlapping, commit by @tehcneko | INTEGRATED | Apply the larger no-action-bar gap in both current profile subtitle positioning paths while retaining the newer offsets and animation. |
| `c9e12ae33` | Revert "Do not compress videos" | SKIPPED | The historical no-compression field is absent. Keep Forkgram's current send-as-file, grouped-media and video conversion paths. |
| `a540042ff` | toggle to disable autoweb login, based on commit by @omg-xtao | SKIPPED | Browser's token attachment and the unified opt-out already use the corrected disableAutowebLogin preference. |
| `96aaad414` | Revert "fix: Fix missing open linked channel, commit by @tehcneko" | SKIPPED | Explicitly reverses 27dbf82f6. Keep current linked-chat menu and permissions. |
| `2f3a63094` | Remove unused file | INTEGRATED | The tracked file was still empty and defined no class. Remove it. |
| `ba435fe3c` | Improve local premium | DEFERRED | This patch mixes purchase locks, UserConfig.updatePremium and story-user eligibility. Later 9a3f784be separates UI entitlement from server status. Batch 4 restored launcher selection. Batch 5 restored the distinct UI predicate, self-profile badge, and local-only purchase preview behavior. Audit remaining account lifecycle and story request effects before extending it. |
| `c2cb1df43` | Adjust Optogram setting icon | INTEGRATED | Use the final adjusted Jaguar PNG in the same tile commit as ca723638e. Launcher alias and icon-pack changes stay separate. |
| `1ca6a2e06` | Finally, Contacts syncing off on first login | SKIPPED | Current login UI and saved-state handling already use a false default. This closes the review of the earlier 16ca13adb sequence without new code. |
| `247ac670f` | Fix memory leak in media activity, commit by @tehcneko | SKIPPED | ImageLoader's video fallback and MediaActivity delegate teardown are already covered by 47e16ffc3 and 32cb2f3e7. |
| `42b796394` | Option to disable open bot button, based on the commit by @omg-xtao | SKIPPED | Both DialogCell and ProfileSearchCell and the unified switch already use disableOpenBotButton. |
| `8ef2393d4` | Fix voip vibration, commit by @omg-xtao | INTEGRATED | The incoming pre-notification part was already restored by 5bba4c964. Integrate the active-call ringtone attributes from c4c47087b. |
| `400b94dd1` | Disable in-app browser google safe browsing, commit by @omg-xtao | DEFERRED | The old SharedConfig browser default no longer exists. Current browser routing uses disableDefaultInAppBrowser, and BotWebViewContainer explicitly enables WebView Safe Browsing. Assess privacy gains and phishing protection together before changing either behavior. |
| `347d23aaf` | Fix disable autoweb login | INTEGRATED | Extend the existing opt-out to ChatActivity's separate authDomains path before requestUrlAuth. The original dotted preference key is a typo. Keep existing host/secret-chat gates. |
| `b41c94d73` | Sort Optogram settings | SKIPPED | The historical row ordering targets the legacy settings layout and includes the bottom-button row. Keep current unified sections and labels. |
| `96ef50446` | Update Readme | SKIPPED | Historical README claims Safe Browsing removal, which remains deferred. The bot-button setting and web login opt-out are covered separately. |
| `42a008e6a` | Show user phone number as unknown to others | INTEGRATED | Complete existing local phone masking in PrivacyUsersActivity. Other historical UI call sites and the unified switch already exist. The patch only affects display and sends no privacy request. |
| `05c1c7295` | Miscelaneous | DEFERRED | Mixed app accent, upload ceiling, billing, native userPremium flag, story stealth gates and profile display. The native flag and upload thresholds need separate tracing. Compare later Miscellaneous ports before adopting surviving parts. |
| `78fc7e36f` | Update Readme | SKIPPED | Old README describes hiding a phone number from other users, while 42a008e6a only masks local display. Keep the current accurate UI description. |
| `e035a9b9f` | Miscellaneous2 | DEFERRED | ImageReceiver applies local Premium to all rendered user avatars and the composer sets premium mode unconditionally. Trace rendering and send effects against later targeted ports. |
| `590d5f241` | Miscellaneous3 | DEFERRED | Mixed changes affect the Boost menu, restriction affordances, routing, and story eligibility. Compare the later Miscellaneous7 and Boost menu changes and separate UI exposure from requests. |
| `5b500b31f` | Miscellaneous4 | DEFERRED | Sticker nopremium classification and avatar/table presentation need call-site review. Compare later Miscellaneous6 and downstream sticker sending and rendering before porting. |

## Batch 5

Baseline `781e178c0`. Examined the remaining three commits of the original
first-parent lineage (`f536c4a72` through `d041fcba2`), then the first 27
commits of the 13.1.1 port (`a5ad8d6ff` through `32473dd02`).
9 integrated, 20 skipped, and 1 deferred.
Resume with `df46603c8` (Treat local Premium as acknowledged in feature preview dialogs).

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `f536c4a722` | Miscellaneous5 | INTEGRATED | Batch 4 covered launcher selection. Restore the other five original checks in LogoutActivity and UserInfoActivity. Both account caps are currently 90, so this primarily changes Premium account-limit prompts. The hard cap and login path stay in place. |
| `234ccc4370` | Fix affiliate showing up without permission, commit by @omg-xtao | INTEGRATED | Use the later 65718061b correction at all three current visibility sites. Keep channel type and server configuration gates, and require channel admin rights before showing the controls. |
| `d041fcba29` | Fix unsafe video rotation parsing in tgcalls | SKIPPED | Both active tgcalls sources moved to jni/tgcalls/tgcalls. They already check the rotation field and read the validated videoRotation iterator. |
| `a5ad8d6ff7` | Establish working Optogram 13.1.1 Forkgram baseline | SKIPPED | The primary Optogram application ID already exists. Preserve 13.2.4 flavor suffixes, signing, and test identities. |
| `9a3f784be9` | Add separate local Premium UI entitlement without changing server status | INTEGRATED | Apply the dedicated local UI capability predicate. UserConfig.isPremium and native or server authorization remain based on the account's actual status. |
| `83d1854af6` | Allow locally enabled Premium launcher icons in selection and lock display | SKIPPED | Batch 4 already restored the final behavior in both icon selection and lock rendering. |
| `f4356ccbd2` | Introduce minimal Optogram settings screen with verified Local Premium toggle | INTEGRATED | Keep the existing switch in the unified screen. Restore its UI refresh notification and update its description for the supported local surfaces. |
| `027e4e7667` | Add Optogram settings entry to Forkgram settings navigation | SKIPPED | The unified Optogram settings entry is already present, including the later Jaguar presentation. |
| `1a2d3ce41a` | Fix Local Premium icon lock check in static view holder | SKIPPED | Batch 4's static icon holder already reads the global preference without relying on a fragment account. |
| `9ac62ead92` | Restore self-profile Local Premium badge without affecting other users | INTEGRATED | Use the current self-profile badge rendering path. The older patch no longer applies. Preserve the real-Premium click gate for changing emoji status and retain other users' badges. |
| `09e838335f` | Show subscribed Premium subtitle for locally enabled UI entitlement | DEFERRED | The referenced subtitle explicitly thanks the user for a Telegram subscription. A local-only toggle cannot truthfully use that text. Reassess the subtitle presentation independently of the local badge and purchase controls. |
| `06c84270c4` | Restore Optogram device identification masking in settings diagnostics | SKIPPED | The old standalone Settings diagnostic branch is absent. Current ProfileActivity diagnostics already mask the device line through be10cbd06. |
| `8cbe845934` | Expose restored diagnostic device-information toggle in Optogram settings | SKIPPED | One unified device-information switch already controls diagnostics and connection initialization. |
| `34b6b7d52b` | Restore Optogram server-facing device model and system version masking | SKIPPED | Batch 3 already passes the conditional Unknown model and SDK into native_init for initConnection serialization. |
| `3e60a2de60` | Correct device masking setting description to reflect server-facing behavior | SKIPPED | The unified device switch already explains the server-reported model and Android version and the restart boundary. |
| `f8a1dd46e5` | Restore Optogram birthday reminder and birthday setup promotion controls | INTEGRATED | The contact birthday reminder gate already exists. Restore the distinct birthday setup promotion gate using disablePromo in the current DialogsActivity path. |
| `10910be8e2` | Expose birthday reminder and birthday promotion preferences in Optogram settings | INTEGRATED | Expose the missing birthday setup switch in the unified screen. Reuse the existing contact birthday reminder switch. |
| `372f6b718b` | Refresh birthday and promotion hints when returning from Optogram settings | INTEGRATED | Refresh the existing hint selector when returning to the dialogs screen. The current other refresh points are tied to preview and search state. |
| `bbd05ba521` | Restore original Optogram profile phone-number visibility preference | SKIPPED | Both original ProfileActivity phone-display sites already respect hidePhoneNumber. Batch 4 also completed the exception-list path. |
| `ffb5b83fa3` | Expose original Optogram hide-phone-number profile preference | SKIPPED | The unified screen already exposes the exact preference. |
| `bfbc968772` | Make expanding Optogram preferences screen vertically scrollable | SKIPPED | The legacy screen is absent. The current unified screen already scrolls. |
| `bd2a48da86` | Expose original archive pull and archived stories controls backed by existing Forkgram behavior | SKIPPED | Forkgram already exposes archive pull and archived stories settings with active consumers. |
| `43f3c5551f` | Restore original Optogram automatic next-message playback preference | SKIPPED | Batch 3 restored the music playlist preference using current cleanup and kept voice playback independent. |
| `b9b97a1137` | Add original Optogram next-message autoplay switch | SKIPPED | The unified music autoplay setting already exists and uses the corrected preference key. |
| `27a6d5c7fa` | Expose existing corrected recent-files attachment suppression in Optogram settings | SKIPPED | Forkgram already provides the recent-files attachment preference and uses it in ChatAttachAlertDocumentLayout. |
| `253cabf7bb` | Expose existing Optogram bot-link parameter protection in settings | SKIPPED | Forkgram already exposes bot-link parameter protection with the existing preference. |
| `80d462ac17` | Restore Optogram dialog thumbnail and last-seen indicator settings backed by existing code | SKIPPED | Forkgram already exposes dialog thumbnail and colored last-seen switches. The current renderer honors these preferences. |
| `3bc2e94d73` | Restore original Optogram sponsored-message suppression in chat rendering | SKIPPED | Existing integration gates sponsored chat messages and the bot ad panel through disableAds. |
| `8d1ca233f5` | Expose original Optogram hide-sponsored-messages switch with default enabled | SKIPPED | The unified switch already defaults to suppressing sponsored messages. |
| `32473dd021` | Hide Premium subscription tiers and purchase footer for local Premium UI | INTEGRATED | Hide the tier chooser and purchase footer for local-only Premium preview. Both footer update sites share the eligibility check. Preserve subscription upgrades for actual subscribers and keep Business purchase UI unchanged. |
