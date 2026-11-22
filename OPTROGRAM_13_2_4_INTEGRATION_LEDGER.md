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
| `9baa26817` | Revert "Added option for interval of updates check." | INTEGRATED | R2 removed the interval row, dialog, Kotlin routing and persisted preference access in baa0bd2d8. The updater now rejects nonmanual checks and retains every reachable forced path. |
| `64866563c` | Revert "Added Forkgram icon to list of devices." | SKIPPED | This upstream revert also removes Desktop icon classification. Keep the newer SessionCell and SessionBottomSheet mappings for remote clients. |
| `89a4fcb84` | Revert "Added new button to settings to check updates." | INTEGRATED | R5 removed the remaining ProfileActivity Forkgram update row, handler and localized labels in a1c431a7f. The primary Settings and debug check actions were removed earlier. |
| `8457f2523` | Revert | INTEGRATED | R5 completed custom updater retirement, including DownloadManagerUtil, GitHub release configuration and the hidden-download filter in f1320a167. Telegram update protocol and installer behavior remain. |
| `7f6a745ae` | Revert "Changed book_logo icon." | SKIPPED | The book logo rollback was an intermediate asset state, superseded by 98bab246a. |
| `d57a9b0ed` | Revert "Replaced default app icon with Forkgram icon." | SUPERSEDED | Batches 8 and 9 restore the final visual behavior with the existing alias names, selected icon compatibility, and plane monochrome layers. The older alias deletion is superseded. |
| `21a028336` | Revert "Replaced launcher icons with Forkgram icons." | SKIPPED | The intermediate ic_launcher_dr rollback was superseded by 98bab246a and later artwork changes. |
| `db149d88b` | Revert "Added new Forkgram icons." | SUPERSEDED | The affected resources match the final Optogram tip. Later history restores the selectable icon pack. Keep its current alias and preference compatibility. |
| `08d11bdcb` | Add option to disable ads | SKIPPED | Sponsored suppression and its unified setting are present through e020480e2 and 66c7ec2fc. |
| `98bab246a` | Replace icons and some strings | INTEGRATED | Artwork was already represented. R6 localized the existing sponsored-message label and branded the test overlay in 0998aac96. Existing Optogram release labels and separate Forkgram F-Droid branding are preserved. |
| `63ce4d4ea` | Option to add Local Premium | SKIPPED | The original patch changes entitlement checks. Keep the current local Premium behavior under the batch constraints. |
| `dce602cc4` | Change some icons | SUPERSEDED | All affected default launcher bitmaps match the final Optogram tip. The early intermediate bitmaps were replaced by later artwork. |
| `9639cbb69` | Make it build | DEFERRED | The settings title and app identity are represented. The mixed build workaround removes browser preferences and changes DNS, signing, variants, and Premium. Review any surviving de-Googling gaps separately against the latest build. |
| `1123c395a` | Change some more icons | SUPERSEDED | All touched raster paths match the final historical tip. The old IntroActivity drawable binding is superseded by the newer intro renderer and its Optogram background port. |
| `d88e8ff7d` | Some branding changes | INTEGRATED | Apply the final display-name behavior from 552b08cfe and update existing localized name overrides. The chat title and settings entry are already branded. Defer icon mappings and diagnostic wording to the appropriate follow-ups. |
| `445094d84` | Add wav and wav_x support, based on commit by Attorelle | SUPERSEDED | Both document MIME variants are recognized through d2d2ce007; Media3 normalizes x-wav and WavExtractor handles supported sample encodings directly. The historical FFmpeg wav name refers to a container, not a sample decoder. R3 adds the independently missing outgoing WAV metadata path in e50793faa. G.711 playback needs device verification because the checked-in FFmpeg prebuild recipe does not enable its mapped decoders. |
| `801611b26` | Change app id | SKIPPED | 9c55abd6b already sets the Optogram application ID for the primary build. Keep newer flavor identities and signing behavior. |
| `28555ec88` | Modify some icons | REPRESENTED | All touched image paths match the final Optogram tip. Keep the current qualifiers and aliases. |
| `92cd90726` | Option to autolock the app immediately | INTEGRATED IN BATCH 6 | The later split port 1fa893219, 79f5a0308, 30ac0f4b2, and cb2193038 supplies the final implementation. Batch 6 also audited the current external-action and media-session paths. Earlier batch totals reflect dispositions at the time of review. |
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
| `bd9a412f8` | Miscellaneous | INTEGRATED | R1 corrected the Fast Forward claim in root listings. R6 added direct-release Optogram listing text in English and Russian in 0711b278d, including the current sponsored-message option. The root listing remains for org.forkgram.messenger. |
| `b0a807898` | Change some strings | INTEGRATED | Use the current branded app name in the Settings section header. Keep current settings copy and sentence casing. |
| `f6b4787ea` | Change more strings | INTEGRATED | Use the current branded app name in the alternate profile settings section header. Shares the Settings branding commit. |
| `f57b4b332` | Change more strings | SKIPPED | Historical title-case changes leave current custom-title, chat prompt, send-as, and emoji behaviors intact. Keep the newer wording. |
| `16ca13adb` | Improve default sync contacts to false | SKIPPED | 338a07ef1 already defaults sync off, including login state restore. Current UserConfig also defaults and clears it to false. The original patch precedes the first-login correction 1ca6a2e06, confirmed equivalent in Batch 4. |
| `a593a66b0` | Revert "Disabled new passkeys." | SKIPPED | Intermediate passkey reversal superseded by ada4ca510 and the current disabled capability. |
| `c00e9757c` | Revert "Added duration info in Shared Voices tab." | SKIPPED | The old reversal targets legacy SharedAudioCell formatting. Keep newer voice captions and metadata layouts. |
| `5a017c6d3` | Revert "Changed notification icon." | SUPERSEDED | All four affected notification PNG paths match the final Optogram tip. The early rollback bitmaps were replaced by the later artwork. |
| `ada4ca510` | Restore disable passkeys | SKIPPED | Current BuildVars capability and setup gates already disable passkeys. The old activity-specific patch is unnecessary. |
| `243e5f70c` | Remove LastFM | INTEGRATED | R6 removed Last.fm clients, authentication, playback dispatch, settings, deep link, resource and build inputs in a6d7ff0f2. The backup allowlist drops the retired preference file and continues to accept older exports. |
| `643fda950` | Increase message selection to 200 | DEFERRED | Both chat and shared-media selection still cap at 100. Keep the previous audit decision pending verification of deletion and other unchunked bulk requests. |
| `3a9dd2c39` | Up version | SKIPPED | Obsolete 12.4.2 version update. Keep the 13.2.4 build version. |
| `ba7a62ad3` | Update gitignore | SKIPPED | Ignoring all Gradle properties is obsolete under current tracked configuration and local credential files. |
| `1f84b0b50` | Update README | SKIPPED | The historical full README rewrite would remove current build and distribution guidance and make claims that need verification. |
| `dc5a9691e` | Update gitignore | SKIPPED | Removing tracked Gradle defaults is obsolete under the newer signing and local configuration model. Related to ba7a62ad3 and 2da084874. |
| `b7528e7cb` | Toggle to hide keyboard on chat scrolling | INTEGRATED | Restore the opt-in setting in the unified Optogram screen using the original preference key. Dismiss only on manual chat dragging. Use the later placement from f6468321f as a guide. |
| `2da084874` | Sample gradle properties | SKIPPED | Historical example superseded by the current local properties and signing setup. Keep obsolete credential configuration out of the repository. |
| `4e53491dd` | update Readme | SKIPPED | Credit-line follow-up to the historical README rewrite. Revisit attribution only in a current documentation update. |
| `82bf42cd5` | View Stats in Message Menu, commit by @immat0x1 | INTEGRATED | Reuse the existing statistics handler with the final eligibility from 3355f8223 and 99722a785. Separate poll statistics and exclude ephemeral and ineligible posts. |
| `644f8d532` | Darken some backgrounds | REPRESENTED | All affected paths, including the picker badge density family and standalone launcher gradient, match the final Optogram tip. The badge still needs a device rendering check. |
| `e22106d34` | Darken some backgrounds | INTEGRATED | Both Android style overlays still used the original blue values. Apply the matching gray theme colors. |
| `7398d11e7` | Update Readme | SKIPPED | Old README and screenshot advertise 200-message selection and other historical states. Keep the current feature and release documentation. |
| `45c60f861` | Reset disconnect timeout on successful connection, commit by @tehcneko | INTEGRATED | The native portion previously landed in 78427b5913. R5 ported the Java cadence in 8eeb73319 using elapsed milliseconds on the account update tick, preserving explicit refreshes and CacheFetcher hash and cache behavior. |
| `a557449fd` | fix some crashes | DEFERRED | The original leftBaseline change targets the old tablet initialization. Current code has a context guard, a cached tablet mode, and a user override. Revisit with a reproducible startup or layout failure. |

## Batch 3

Baseline `7071ab713`. Examined `bf941a730` through `228521f4e` inclusive.
7 integrated, 11 skipped, and 12 deferred.
Resume with `6c7c51c29` (Spoof as  Windows when OEM device model is disabled).

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `bf941a730` | Revert "Replaced frequent contacts with logged in accounts in App Shortcuts." | SKIPPED | Current MediaDataController combines visible-account and opt-in contact shortcuts, caps the latter after reserving account slots, and suppresses them behind passcode or hidden-account gates. The old replacement would remove newer shortcut behavior. |
| `af0854279` | some fixes | INTEGRATED IN R1 | The newer channel buttons already label search, gift, direct and broadcast-group info. R1 labels the current Recent Actions info button using the localized title of the dialog it opens. |
| `0861de9d6` | some more fixes | INTEGRATED | Grouped HQ entry preservation landed in ca5d3e6e3. R3 completed the rebuild in 8cbdfac4a with alias-safe release of private bitmaps, synchronous writes and preservation of the earlier edited path for fallback and shared consumers. |
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
| `0bec92872` | Fix NPE | SUPERSEDED | R6 verified that Media3 uses a nonnull audio buffer sentinel, guards video buffer allocation and allows absent supplemental data. The old ExoPlayer patch would clear nullable buffers or mutate them after returning them to the owner. No corresponding defect was found in the active code. |
| `ccdb3c2c3` | add multi share, commit by @dic1911 | INTEGRATED IN BATCH 7 | The later dc5834259 port resolves this entry. The current implementation checks all members and files, preserves protected content, and grants read-only content URIs for the album. |
| `eff4d8268` | Fix sharing web links | SKIPPED | LaunchActivity already combines a subject with incoming HTTP(S) text shares, the behavior also carried by 6e7c2efe0. |
| `c8305e930` | Some more changes | DEFERRED | Poll editor gates and emoji tab changes are mixed with a local Premium predicate change. Compare poll entity serialization and newer poll restrictions before adopting the intended per-context behavior. |
| `d60bd9b51` | Disable Use_Delegate_Host_Resolve to prevent using Google servers, commit by @Timothy Redaelli | REPRESENTED | Batch 8 replaced the Google hostname resolver with Android system DNS. Keep native delegation for asynchronous IPv6-capable resolution. The old macro removal would force the blocking IPv4-only native fallback. |
| `4dc4c401e` | Replace Google dns with Adguard | REPRESENTED | Batch 8 integrated later 2741e47503 recovery via AdGuard and Cloudflare. The existing F-Droid special-resolver skip matches d78008446. Batches 9 and 10 handled validation and completion. Network verification remains. |
| `681288265` | Disable geo location for  webview | SKIPPED | Default WebView geolocation denial and explicit opt-in already exist through badf97380 and 9c58060f6. |
| `0265c9ca9` | Edit some launcher icons | REPRESENTED | All affected foreground and background resource paths match the final Optogram tip. Covered by the early gradient restoration and Batch 8 artwork port. |
| `c6fff4052` | Edit some more launcher icons | REPRESENTED | All five Aqua foreground PNGs match the final Optogram tip and the selector uses icon_foreground_saa through the Batch 8 port. |
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
| `9beb5107b` | fix: text input value UI oerflow, commit by @dic1911 | INTEGRATED IN R1 | Clamp width calculations before passing them to MeasureSpec, including decorated rows with the newer layout. Keep AnimatedTextView and its current text fitting rather than using the old character-count truncation. |
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
| `e035a9b9f` | Miscellaneous2 | DEFERRED | R4 integrated the avatar portion through the later targeted 022240b4ed. The separate composer SlowModeBtn default remains unresolved because the subsequent delegate controls slow-mode and restriction hints. See 49b63e32d8. |
| `590d5f241` | Miscellaneous3 | DEFERRED | Mixed changes affect the Boost menu, restriction affordances, routing, and story eligibility. Compare the later Miscellaneous7 and Boost menu changes and separate UI exposure from requests. |
| `5b500b31f` | Miscellaneous4 | INTEGRATED | Batch 9 integrated sticker classification through e583657a2. R4 integrated account-aware avatar presentation and the self-only table badge through 37637234e, 381a0208d and 6416411c7. |

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
| `09e838335f` | Show subscribed Premium subtitle for locally enabled UI entitlement | INTEGRATED | R2 gives local-only previews a distinct Optogram subtitle in c2fb5e394. Existing Telegram subscriber and purchase-confirmation copy remains tied to the existing subscription and confirmation paths. |
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

## Batch 6

Baseline `f3a55a475`. Examined the next 30 first-parent commits on the 13.1.1
port, `df46603c8` through `b401f0bb9` inclusive. 5 integrated,
25 skipped, and 0 deferred.
Resume with `7a7832f51` (Expose Optogram preferences within combined Forkgram settings).

Birthday settings audit found one switch for each of `disableBirthdayReminder`
and `disablePromo`. Both settings and their production hint conditions use
`false` for the suppression default. `DialogsActivity.onResume()` refreshes
both hints. The separate `hidePremiumSpeedPromo` setting retains its own
consumer. No birthday correction was needed.

The Local Premium acknowledgement uses the sheet's existing account and stays
within the UI. It does not mark another user as Premium or change server status.
The subscribed-subtitle deferral remains independent. DNS, reconnect behavior,
updater retirement, launcher artwork and Media3 WAV support had no final port
in this range and remain open.

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `df46603c84` | Treat local Premium as acknowledged in feature preview dialogs | INTEGRATED | Use the existing account's local UI eligibility for the acknowledgement overlay. Refresh on local and real Premium events. Keep gift and force-About handling and leave purchase and authorization methods intact. |
| `217a531925` | Respect Optogram automatic web-login opt-out before attaching tokens | SKIPPED | Browser already checks the unified preference before attaching automatic web-login tokens. ChatActivity separately honors it for requestUrlAuth. |
| `b69e847cdf` | Expose working automatic web-login privacy preference in Optogram settings | SKIPPED | The existing unified setting reads and writes disableAutowebLogin. |
| `12ce442286` | Keep contacts sync opt-in visible and disabled by default throughout login | SKIPPED | LoginActivity already shows the opt-in during login and restores absent saved state as false. UserConfig also defaults off. |
| `9d9003bac2` | Honor Optogram bot-open-button preference in DialogCell.java | SKIPPED | DialogCell already gates the bot open button on the same preference. |
| `aa7c49d137` | Honor Optogram bot-open-button preference in ProfileSearchCell.java | SKIPPED | ProfileSearchCell already gates the bot open button on the same preference. |
| `a290f48c60` | Expose correctly wired Optogram bot-open-button setting | SKIPPED | The unified screen already exposes disableOpenBotButton. |
| `65718061b2` | Require channel admin rights at all affiliate controls visibility sites | SKIPPED | Batch 5 applied this final three-site admin gate under 3cd4f99a3. |
| `1a0754fb94` | Default embedded bot WebView geolocation to disabled with explicit opt-in | SKIPPED | BotWebViewContainer already blocks geolocation by default and reads the explicit opt-in on WebView setup. |
| `e8e7e9f693` | Add user-controlled WebView geolocation protection to Optogram settings | SKIPPED | The unified geolocation switch already uses disableWebViewGeolocation. |
| `a2f119a899` | Release MediaActivity bulletin delegate when fragment is destroyed | SKIPPED | 32cb2f3e7 already removes the delegate during fragment teardown. |
| `c4c47087bc` | Tag active VoIP call vibration with ringtone audio usage | SKIPPED | edd16759f already restores ringtone attributes in active VoIPService. |
| `1fa8932199` | Restore immediate passcode auto-lock option in settings | INTEGRATED | Expose the saved one-second sentinel as Immediately using a string resource. Keep current durations, persistence, and picker navigation. |
| `79f5a03082` | Honor immediate passcode auto-lock in AndroidUtilities.java | INTEGRATED | Honor the sentinel in the existing passcode foreground/background gate and the newer media-session timestamp check. Preserve existing timed lock and clock rollback behavior. |
| `30ac0f4b2e` | Honor immediate passcode auto-lock in BubbleActivity.java | INTEGRATED | Use the existing one-second guarded scheduling path for the sentinel in BubbleActivity. |
| `cb21930383` | Honor immediate passcode auto-lock in LaunchActivity.java | INTEGRATED | Use the existing one-second guarded scheduling path in LaunchActivity and its external-action counterpart. Keep resume checks and runnable cancellation. |
| `9b75d11e29` | Honor Optogram phone-number hiding in ProfileSearchCell.java | SKIPPED | ProfileSearchCell already masks the number when hidePhoneNumber is set. |
| `2a4946a428` | Honor Optogram phone-number hiding in PrivacyUsersActivity.java | SKIPPED | 0df92bcda already covers the privacy exception list. |
| `405d1b0fa9` | Respect phone-number masking in alternate profile layout | SKIPPED | ProfileActivity2 already masks the number using the unified preference. |
| `144c5dd9c5` | Clarify that Optogram phone-number hiding is local display masking | SKIPPED | Current unified setting already explains the local display scope and distinguishes Telegram privacy settings. |
| `298f3b7267` | Restore Optogram From Bot label in current chat message header renderer | SKIPPED | 95fc5eda4 already restores bot attribution in the current header. |
| `b3f18d7423` | Add localized resource key for Optogram From Bot message label | SKIPPED | The IsFromBot resource is already present. |
| `868489e246` | Restore From Channel attribution in modern megagroup message header | SKIPPED | 95fc5eda4 already restores channel attribution in the current header. |
| `be15c8afb4` | Restore From Channel label string resource | SKIPPED | The IsFromChannel resource is already present. |
| `7be3e6549f` | Restore participant joined date in modern member menu | SKIPPED | b8d4527e7 already covers the profile and member-management menus and preserves the actual server date on cache load. |
| `4dcd7466ca` | Keep original member-menu eligibility when join date is unavailable | SKIPPED | Current profile eligibility requires either the original menu actions or a positive join date. |
| `5c18722efe` | Avoid empty separator in joined-date-only member menu | SKIPPED | Current separators are conditional on preceding actions. |
| `3355f82230` | Restore gated View Stats action for eligible channel posts | SKIPPED | e70acc85e already restores eligible channel-post statistics. |
| `99722a785b` | Keep channel message stats separate from poll and ephemeral menus | SKIPPED | Current statistics action excludes polls and ephemeral posts and keeps the poll-specific action separate. |
| `b401f0bb97` | Apply Hide Sponsored Messages preference to bot ad panel | SKIPPED | Current bot ad panel already checks disableAds with a true suppression default. |

## Batch 7

Baseline `46ae8a928f`. Examined the next 30 first-parent commits on the
13.1.1 port, `7a7832f51` through `c960a92e9` inclusive.
4 integrated, 21 skipped, and 5 deferred.
Resume with `3bc748250` (Restore dark original launcher icon background).

Batch 6 committed diff `f3a55a475..46ae8a928f` contains nine files, 93 insertions
and 28 deletions. The previously reported large working-tree diff included the
two pre-existing wallet-engine modifications. Neither file was committed.

The current Java settings screen remains the sole visible Optogram settings
entry. The Kotlin ForkSettings registry is a programmatic interface with scoped
test-build writes, independent of normal row persistence. Existing registry
keys and custom title behavior are unchanged. Local Premium remains an
installation-wide preference resolved through the active account's UI predicate.
Existing sponsored, birthday, device privacy, and passcode paths keep their keys
and defaults. DNS/reconnect, updater retirement, launcher artwork, Media3 WAV,
and subscription subtitle remain open.

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `7a7832f51f` | Expose Optogram preferences within combined Forkgram settings | SKIPPED | The unified ForkSettingsActivity already contains the Optogram rows and backing preferences. The historical intermediate extra preferences link has no current destination. |
| `fd3c316bea` | Unify Optogram and Forkgram settings under one entry | SKIPPED | SettingsActivity already opens the unified ForkSettingsActivity from its Optogram entry. Keep the current navigation and search. |
| `f911786eef` | Move sponsored-message preference into unified Optogram settings | SKIPPED | The unified screen already owns the sponsored toggle with disableAds defaulting true. |
| `56d70f207b` | Remove duplicate sponsored-message toggle from legacy preferences page | SKIPPED | There is no legacy OptogramSettingsActivity or duplicate sponsored row to remove. |
| `536db30300` | Restore original Jaguar icon for Optogram Settings | SKIPPED | Batch 4 already restored the final Jaguar asset and current settings tile. |
| `a418c19a51` | Move device identity and WebView geolocation privacy toggles into unified Optogram settings | SKIPPED | The unified device and geolocation rows already use their original keys and defaults. Device metadata is read on connection initialization and geolocation on WebView setup. |
| `db3faf86ff` | Consolidate web login, bot button and phone masking privacy settings | SKIPPED | The unified page already contains web-login, bot-button, and phone masking controls with current consumers. |
| `15617a89a9` | Remove duplicated Optogram toggles already implemented in Forkgram settings | SKIPPED | Keep Forkgram's archive, thumbnails, last-seen, recent attachments, and bot-link rows. The removed legacy duplicate settings are absent. |
| `e95e5f3e2d` | Integrate Optogram audio playlist autoplay control alongside Forkgram voice autoplay | SKIPPED | Batch 3 restored the music playlist control separately from Forkgram voice autoplay. |
| `f6468321f7` | Restore optional keyboard dismissal on manual chat scrolling | SKIPPED | Batch 2 already added the opt-in manual drag behavior and one unified row. |
| `05687a82b5` | Use Optogram Client as the default custom app title | SKIPPED | fc31ed760 implements the later Optogram default and preserves stored custom titles, including through ForkSettings.kt. |
| `fddb7d0be5` | Add local birthday hint diagnostics using shared production suppression gates | SKIPPED | Intermediate birthday diagnostic UI was removed by 908a70cbe. Both production suppression paths are already present. |
| `71c2275fdb` | Render birthday diagnostic output with actual line breaks | SKIPPED | Formatting fix for the removed diagnostics. Preserve the production hint refresh. |
| `08bc01017e` | Move Optogram local premium and birthday controls into Privacy and Security | INTEGRATED | Move the existing Local Premium and two separate birthday controls below the unified Privacy and Security heading. Keep keys, IDs, defaults, and callbacks. Exclude diagnostics removed in 908a70cbe. |
| `7e99ab8ee6` | Restore WAV and X-WAV music document recognition | SKIPPED | WAV and X-WAV document classification is already present via d2d2ce007. This patch does not address the deferred Media3 decoder support. |
| `0fa046e936` | Raise shared media message selection limit to 200 | DEFERRED | The Batch 2 audit found unchunked deletion and story requests plus other bulk consumers. Confirm limits and failure handling before raising shared-media selection. |
| `90ff756bf6` | Increase main chat message selection limit to 200 | DEFERRED | The standard forward path chunks at 100, while multiple other bulk operations do not. Keep the chat limit pending the coordinated audit with 0fa046e93. |
| `dc58342595` | Restore sharing entire media groups | INTEGRATED | Restore the viewer's single-item or album chooser. Reuse the current file-resolution path, validate each member against account, dialog, group, and protected-media conditions, and require every file before granting content URIs. Keep ordinary single-item sharing. |
| `94852d6500` | Restore grouped media sharing and phone sharing prompt control | SKIPPED | This commit implements phone prompt suppression and its old PrivacySettingsActivity row. Batch 3 already uses the corrected condition and one unified row. The PhotoViewer album patch is separate. |
| `765b338ab0` | Disable passkey creation in unofficial Optogram client | SKIPPED | The capability is false and PasskeysController rejects registration before credential or network work. The current registration entry also sits behind the disabled settings route. |
| `577285279b` | Hide unsupported passkey setup from privacy settings | SKIPPED | PrivacySettingsActivity already gates the passkey row and its click handler on the disabled capability. |
| `ee08b028c6` | Disable unsupported passkeys in Optogram build configuration | SKIPPED | BuildVars.SUPPORTS_PASSKEYS is already false. |
| `6a414559e3` | Hide unsupported passkey suggestion | SKIPPED | DialogsActivity already gates SETUP_PASSKEY on the disabled capability. |
| `915991593a` | Miscellaneous4 | INTEGRATED | R4 passes the binding account through vector rendering and compares account and small-thumbnail presentation mode before reusing drawables. Profile-sized presentation is unchanged. See 37637234e and 381a0208d. |
| `022240b4ed` | Miscellaneous2 | INTEGRATED | R4 scopes small animated vector avatars to self in the binding account and rebinds affected cells on premiumStatusChangedGlobal and attach. The local path uses already-known markup and preserves the genuine-Premium full-user fetch gate. See 381a0208d. |
| `3219810f78` | Miscelaneous | INTEGRATED | The account cell binds the actual user for its account. Use that account's existing local UI predicate for the badge and preserve emoji status precedence. No user or server status mutation. |
| `51f512168c` | Miscelaneous | DEFERRED | The two StealthModeAlert checks govern an active TL_stories_activateStealthMode send path. Separate preview acknowledgement from authorization and verify cooldown and error handling before changing this gate. |
| `b70e4143f0` | Fix disable autoweb login | SKIPPED | Browser and the separate ChatActivity URL-auth branch already check the corrected disableAutowebLogin key. |
| `b440adabbd` | Disable Premium Promo | SKIPPED | DialogsActivity and the unified switch already use hidePremiumSpeedPromo for the download-speed promotion. |
| `c960a92e92` | Make all launcher icons available without Premium | INTEGRATED | Apply the final launcher availability flags to the three affected icons. Keep aliases, artwork, and the existing selector implementation, which continues to honor local UI eligibility wherever an icon is marked Premium. |

## Batch 8

Baseline `b84a355070`. Examined the next 30 first-parent commits on the
13.1.1 port, `3bc748250` through `106a5b257` inclusive.
16 integrated, 9 skipped, and 5 deferred.
Resume with `e583657a2` (Miscellaneous6).

The early numbered launcher artwork deferrals are substantially covered by
`0ba245d28` and the Default/Adaptive artwork sequence. App-level launcher
resources and any density or flavor assets outside these patches remain for
later reconciliation. No activity aliases were renamed.

System hostname DNS and final AdGuard/Cloudflare datacenter recovery replace
the earlier deferred Google-specific routes. Java delegation remains enabled for
asynchronous and IPv6-capable resolution. Batch 9 confirmed both native proxy and WebSocket routes and added the newer active-link IP strategy. Native timeout reset is integrated,
while app-config refresh remains open. Updater retirement advanced through the
automatic, primary Settings and debug routes, with current standalone prompts
and pending-update recovery still in place. The 200-item limits, Media3 WAV,
avatar and Stealth Mode paths, and subscription subtitle remain deferred.

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `3bc7482500` | Restore dark original launcher icon background | SKIPPED | The standalone gradient matches the historical blob byte-for-byte through 49702b3ac. |
| `0ba245d28a` | Edit some launcher icons | INTEGRATED | The numbered launcher artwork patch applies against the current source blobs. Carry its PNG variants together, including the Aqua selector foreground mapping. Manifest aliases are unchanged. |
| `8af4e3e01d` | Remove app update entry from settings | INTEGRATED | Remove the primary Settings update row and handler. Keep the Optogram settings entry and other Settings actions. |
| `e0d1359286` | Disable automatic Forkgram app update checks | INTEGRATED | Remove the automatic updater call on resume. Keep existing pending update and terms handling. |
| `360b66b0b8` | Remove Forkgram update check from debug menu | INTEGRATED | Remove the check action from the current DebugSettingsActivity and the alternate ProfileActivity debug menu. Keep the positional debug IDs intact. |
| `11149574e5` | Remove obsolete app update debug action | INTEGRATED | R5 removed the remaining manual pending-update reset actions from the current ProfileActivity and DebugSettingsActivity in 9af5bee88. Telegram mandatory and optional recovery remain. |
| `202aa1f9bb` | Restore Telegram artwork for Default and Adaptive launcher icons | INTEGRATED | Align the Default and Adaptive selector previews with the historical original artwork resources. |
| `33bb3f6768` | Restore Telegram artwork for Default and Adaptive launcher icons | INTEGRATED | Restore the regular Default alias foreground/background. Use the existing plane mask for themed icons. |
| `98a7c8788f` | Restore Telegram artwork for Default and Adaptive launcher icons | INTEGRATED | Restore the round Default alias foreground/background and keep the plane monochrome asset. |
| `46d9480f24` | Restore Telegram artwork for Default and Adaptive launcher icons | INTEGRATED | Restore the Adaptive alias foreground/background and keep the plane monochrome asset. Preserve manifest component names and API qualifiers. |
| `d189f6a0b5` | Remove unused Forkgram app updater entry point | INTEGRATED | R5 removed the Forkgram LaunchActivity entry point in 85e3d6d28. Existing standalone unsupported-content prompts use the independent Telegram protocol flow, as in Optogram 13.1.1. |
| `cd38138f0a` | Remove obsolete Forkgram app updater | INTEGRATED | R5 removed AppUpdater, DownloadReceiver, update channel configuration and startup installer cleanup in c20cd506c. The interval retired in R2, and the remaining custom callers and helper retired in R5. |
| `eaa65f0947` | Use dark grey background on intro screen in night theme | INTEGRATED | Use the historical night gray across the current intro fragment, placeholder, GL texture reload and animation background. Keep the newer debounce and theme animation handling. |
| `018ad25117` | Remove stale update interval settings search result | INTEGRATED | R2 removed the stale settings-search result in df89f15750. |
| `5be174619e` | Add Optogram version footer string | INTEGRATED | Add the original Optogram version footer resource. |
| `a2c0e65145` | Show Optogram name in settings version footer | INTEGRATED | Use the historical footer string while preserving version, build code and ABI formatting. |
| `0faa19b9ea` | Miscellaneous5 | SKIPPED | The selector already checks local eligibility where an icon is flagged Premium. Batch 7 made the three historical icons available without that flag. |
| `72d928809f` | Fix static app icon holder local premium check | SKIPPED | The static holder already uses the global preference rather than a fragment account field. |
| `732fe0261f` | Correct Optogram settings search title | INTEGRATED | Correct the existing search/resource title and localized branding overrides. Reuse that same string for the visible settings tile. |
| `8d50743117` | Use system DNS for delegated host resolution and WebSocket fallback | INTEGRATED | Remove hard-coded Google host lookups from the delegated and WebSocket paths. Use InetAddress system resolution and preserve asynchronous dispatch, address handling and native callbacks. |
| `b95c7ced87` | Disable native delegated host resolution for system DNS | REPRESENTED | System DNS is active through the Java delegate from 49928ddf3a. Keep the delegate, async callbacks and IPv6 support. The historical macro change is unnecessary for the final behavior. |
| `08b5c48bd5` | Disable special DNS resolver for all Optogram build variants | SKIPPED | The intermediate all-flavor recovery disable was reversed by d78008446. |
| `2741e47503` | Preserve datacenter DNS recovery via AdGuard and Cloudflare without Google | INTEGRATED | Restore AdGuard TXT resolution with the existing Cloudflare fallback. Remove the unused Google TXT task and preserve the startup guard and native signed configuration handling. |
| `d780084468` | Re-enable non-Google datacenter recovery for non-F-Droid builds | SKIPPED | The current Gradle field already skips special recovery only for F-Droid, matching the final historical variant split. |
| `3340672ecc` | Expose Optogram toggle to suppress phone number sharing prompt | SKIPPED | Batch 3 added one unified phone sharing prompt toggle and the corrected condition. |
| `6503325349` | Reset native disconnect recovery timeout after successful reconnect | INTEGRATED | Gate recovery timeout accumulation on available, unpaused networking. Reset it on reconnect to the current datacenter's generic connection. The Java app-config throttling from 45c60f861 remains deferred. |
| `4330e3da02` | Preserve original photo entry when sending high-quality grouped photos | SKIPPED | ca5d3e6e3 already preserves edited still-photo entries for the grouped high-quality worker. |
| `1cb58e38ab` | Guard Settings back navigation before action bar initialization | SKIPPED | ecfbb6294 already protects the current SimpleActionBar back navigation. |
| `08fcc356ad` | Avoid image decoding fallback for unavailable video thumbnails | SKIPPED | 47e16ffc3 already skips the generic decode fallback for unavailable video thumbnails. |
| `106a5b2572` | Honor local Premium setting when displaying chat Boost menu | INTEGRATED | Use account-aware local UI eligibility to expose the Boost menu. Keep chat capability checks, admin routing and the existing userCanBoostChannel check before any boost action. |

## Batch 9

Baseline `95864ca3ed`. Examined 30 first-parent commits on the 13.1.1 port
through the documented Forkgram-base continuation, `e583657a2` through
`3a6334bc8` inclusive. 13 integrated, 12 skipped, and
5 deferred. Resume with `997123f94`
(Avoid restricted emulator detection probes on Android 11+).

### DNS and reconnect boundary

Native hostname delegation remains enabled. Both proxy and WebSocket
hostnames reach Java. Ordinary resolution uses system DNS with IPv4 and IPv6
results. Recognized WebSocket hosts use their own queue/cache with IPv4
preference and IPv6 fallback. Android 11+ IP strategy now uses the active
network's LinkProperties and preserves the existing CLAT selection precedence.
Pre-Android 11 enumeration remains available.

Emergency datacenter recovery is separate. Non-F-Droid builds request AdGuard
TXT payloads with Cloudflare fallback, while F-Droid skips special recovery.
The current Java paths have no hard-coded Google DNS endpoint. The native
decoder still authenticates and date-checks configs. Recovery timeout accrues
only while online and unpaused and resets upon a generic current-DC reconnect.
A separate correction rejects undersized payloads before handing them to JNI
and reads the rejected-config dates before freeing the object. Native changes
need compilation alongside device coverage. The separate Java app-config
refresh change remains open.

### Updater call graph

Automatic checks remain absent. ProfileActivity's alternate row is a manual
caller. Standalone update prompts in ChatActivity, ChannelAdminLogActivity,
and PeerStoriesView still reach the two-argument LaunchActivity.checkAppUpdate.
It calls AppUpdater, which checks the Telegram release channel or legacy
release flow and owns download registration. DownloadReceiver completes the
APK flow. LaunchActivity also clears cached installers once and resumes the
stored pendingAppUpdate gate. Its unused three-argument overload has no
current callers and uses a different Telegram update RPC. The interval timer
does not gate current forced callers. Full retirement remains deferred until
the prompt, installation and stored-update paths have an agreed replacement.
Selection limits, Media3 WAV, avatar rendering, Stealth Mode, subtitle and
Java app-config refresh remain deferred.

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `e583657a2e` | Miscellaneous6 | INTEGRATED | Apply the exact instance-method guard. With Local Premium off, a media nopremium flag still suppresses Premium sticker effects. With it on, use the same underlying document classifier as unflagged media. Static classification, sending, and UserConfig status are unchanged. |
| `49b63e32d8` | Miscellaneous7 | DEFERRED | The current composer uses this delegate to suppress slow-mode and restricted-send hints. The historical unconditional true would silence those hints even on chats without boost eligibility. Trace the intended affordance separately from the actual boost and send restrictions. |
| `e3d55bb6b6` | Miscellaneous9 | SKIPPED | Batch 5 Miscellaneous5 already applied both logout checks. |
| `367854c860` | Miscellaneous9 | SKIPPED | Batch 5 Miscellaneous5 already applied all three account settings checks. |
| `28151a6291` | Miscellaneous10 | INTEGRATED | Carry the same local account-prompt behavior into MainTabsActivity without changing the current hard account cap. |
| `2cb33b745a` | Miscellaneous11 | SKIPPED | Batch 4 applied the no-actions profile subtitle offset in both current layout paths. |
| `90ba2ad9eb` | Miscellaneous12 | INTEGRATED | Use the local UI capability in the current emoji tab calculation. Preserve the separate allowEmojisForNonPremium condition and existing send gates. |
| `4c8448aa79` | Fix ringtone vibration attributes on older Android versions | SKIPPED | 5bba4c964 already passes ringtone audio attributes on the pre-Android 13 branch. |
| `287f5e4f29` | Miscellaneous13 | INTEGRATED | Restore conditional sticker suggestions and request animated results from the local keyword-suggestion path using the current adapter account. Keep selection, sending and controller checks. |
| `b6e274e6ee` | Miscellaneous13 | INTEGRATED | Request the existing animated keyword-suggestion variant in StickersAdapter using local UI eligibility. Other sticker and sending behavior stays in the current code. |
| `57c990543a` | Miscellaneous14 | DEFERRED | The original TranslateController checks combine the chat translation setting, local provider and Telegram translation requests. The newer controller also handles rich messages and autotranslation. Trace eligibility and error behavior per provider before porting. |
| `82d5a8e75e` | Miscellaneous15 | DEFERRED | The ArchiveSettingsActivity row both advertises eligibility and persists a Telegram global privacy update. Current code also uses autoarchiveAvailable. Review the response and rollback behavior before changing this shared gate. |
| `cbef5a1d03` | Miscellaneous15 | INTEGRATED | Use the actual account's local UI predicate to render its existing folder tags. Preserve the folderTags preference and its consumers. |
| `d8fcd0cca5` | Miscellaneous16 | DEFERRED | The lock state switches the featured emoji pack from an upsell to installation and removal controls. Review the add/remove handlers and installStickerSet error handling across current hosts before exposing actions. |
| `7efca28091` | Miscellaneous17 | DEFERRED | The current recommendation card's More action still gates the recommendations tab in ChatActivity. Porting only the card would advertise a More action that opens an upsell. Review tab access and returned results together. |
| `552b08cfef` | Update application display name to Optogram | SKIPPED | Batch 1 already branded the default and localized app name resources. |
| `aa550fca29` | Update remaining settings-lock branding to Optogram | INTEGRATED | Default settings-lock copy was already integrated. R6 applied the same brand correction to three stale strings in each of ten locales in a97e05ab6. Resource keys and lock behavior remain intact. |
| `83265120a6` | Use dark Telegram adaptive icon for application branding | INTEGRATED | Apply the final dark standalone background and plane foreground to app-level ic_launcher while preserving its plane monochrome layer. |
| `7d785231e7` | Use dark Telegram adaptive icon for application branding | INTEGRATED | Apply the matching variant to ic_launcher_round with alias names and the monochrome layer unchanged. |
| `a9fdee75da` | Clean up Optogram branding and redundant settings UI | SKIPPED | fc31ed760 already uses the Optogram default without rewriting saved custom titles. |
| `f7abadcaa3` | Clean up Optogram branding and redundant settings UI | SKIPPED | The legacy OptogramSettingsActivity is absent. |
| `83601ed534` | Clean up Optogram branding and redundant settings UI | INTEGRATED | Remove the redundant unified-screen shortcut and click route. NotificationsSettingsActivity remains the real settings destination. |
| `ab52e06876` | Normalize legacy default chat title to Optogram | SKIPPED | The default header is already Optogram. The historical string-equality migration would overwrite the display of user-entered titles that happen to match former defaults. |
| `663cbac073` | Normalize legacy default chat title to Optogram | SKIPPED | The settings row, edit dialog, and programmatic option already share the Optogram default. Preserve saved titles verbatim for the same reason as ab52e0687. |
| `d45e24222d` | Remove obsolete UnifiedPush settings search shortcut | INTEGRATED | Remove the obsolete search shortcut and its dead Kotlin navigation alias and row ID. Preserve the live DisableUnifiedPush search route. |
| `908a70cbe4` | Remove remaining birthday diagnostics from active Optogram settings | SKIPPED | Production birthday switches already refresh without the removed diagnostic row. |
| `c898e603f6` | Avoid cross-directory rename during scoped-storage media path probes | INTEGRATED | Use the historical copy-based media path probe on scoped-storage Android versions. Keep the older rename probe and existing file cleanup. |
| `754cd3e57b` | Keep release signing credentials in local configuration | SKIPPED | Current release signing already obtains credentials from local configuration without restoring the older tracked fields. |
| `cbeb12069d` | Use active network link properties for IP strategy on Android 11+ | INTEGRATED | Use active LinkProperties on Android 11+. Preserve legacy IPv6-forced, mixed CLAT and IPv6-only precedence. Keep older network enumeration and the current Java/native callback interface. |
| `3a6334bc85` | Load Telegram API credentials from local properties and reject placeholders | SKIPPED | Current Gradle configuration already reads and validates Telegram API values with local properties support and rejects placeholders. |

## Batch 10

Baseline `73bdb37e227`. Examined the remaining four first-parent commits,
`997123f94` through `6ddae5097` inclusive, on the Forkgram-base continuation.
Four integrated, zero skipped, and zero newly deferred. `6ddae5097` is the
tip of the available historical lineage. No further first-parent commit is
available on these refs.

The resolver's 256-byte minimum matches Datacenter::decodeSimpleConfig.
Invalid Base64 and truncated TXT payloads fail before native application.
The native decoder retains its RSA/hash, deserialization and date checks.
Rejected-date logging reads the fields before freeing the config. Final
Cloudflare transport/parser failures now complete the native recovery
attempt using a valid zero-length buffer through the existing JNI method.
Success and exhausted native validation also clear the phase and TLS
mismatch marker. An earlier native library safely treats the empty buffer
as invalid and may follow its earlier retry sequence. F-Droid keeps
skipping the special resolver and makes no recovery DNS request. The
current native library must be rebuilt to exercise the new completion
semantics.

Deferred features remain open. This last segment supplied no final ports for
Local Premium composer hints, translation, autoarchive, featured packs,
recommendations, avatar rendering, Stealth Mode, 200-item selection, WAV
decoding, Java app-config refresh, subscription text, standalone updater
retirement, or remaining launcher artwork.

| Historical commit | Title | Disposition | Current behavior and follow-up |
| --- | --- | --- | --- |
| `997123f94ad` | Avoid restricted emulator detection probes on Android 11+ | INTEGRATED | Remove serial-number heuristics and skip the legacy kernel driver file reads on Android 11+. Keep public Build heuristics and other detector paths. Treat a null reflective property as unavailable so the remaining probes can continue. |
| `aa819aa9884` | Avoid restricted emulator detection probes on Android 11+ | INTEGRATED | Replace the Android 11+ procfs input-device read with the public InputDevice list. Keep the original name checks and pre-Android 11 path. |
| `033269bbebb` | Open Optogram settings from push service notification | INTEGRATED | Use the current unified settings deep link and an explicit immutable LaunchActivity intent. Reuse the open settings screen on subsequent taps. Preserve notification lifecycle and push configuration. |
| `6ddae509718` | Use Optogram log tag for push service diagnostics | INTEGRATED | Apply the Optogram log tag to the ApplicationLoader push startup and watchdog messages. The preceding service commit also updates its diagnostics. |

## Reconciliation R1

Baseline `41f908ac61a`. Reconciled 14 historical deferrals, leaving 38 rows
marked DEFERRED. Batch totals above record dispositions at the time of each
batch. Partial updater retirement, the Java portion of app-config refresh, the
bitmap portion of grouped-photo rebuild, and store branding stay open.

Compared 216 tracked launcher resource paths with `6ddae5097`, including
regular and round Default aliases, Adaptive, numbered and app-level resources,
and the forkTest overlay. Three alias XMLs intentionally keep the plane
monochrome layer with the historical foreground and background. Four
standalone gradients match the earlier `2865d363a` Optogram artwork. All
other compared paths match the historical tip. Debug, standalone and release
manifest mappings keep their current flavor and component identities.
Merged-resource and launcher runtime checks remain to be run.

Source review found the missing Recent Actions info accessibility label
and an arithmetic underflow in decorated settings-row width measurement.
Both are corrected under their historical subjects. Notification navigation
already uses the immutable unified-settings link and reuses an open settings
screen. No independent tablet startup defect was established. English and
Russian metadata now describe Fast Forward for eligible messages, with the
existing F-Droid branding retained. No native, network, updater lifecycle,
or request-coupled Local Premium changes were made in R1.

## Reconciliation R2

Baseline `00221ed8f0f`. Resolved three historical entries, leaving 35 rows
marked DEFERRED. Retired the Forkgram update interval and settings-search
shortcut. All five reachable two-argument update callers explicitly pass
`true`. The existing prompts, download receiver, APK handoff, cached installer
cleanup and stored pending-update recovery remain reachable.

Local-only Premium previews use distinct Optogram copy with an English fallback.
The subscription and post-purchase confirmation flows retain their existing
copy. Avatar work remains open. ProfileActivity, ProfileActivity2 and
ProfileGalleryView have user/peer context, but profile-sized vector rendering
does not use the flag for animation selection. ImageReceiver owns the small
preview path and has a binding account plus the rendered user ID. A future
change must verify self against that account, carry the binding account into
vector loading and ensure equality/rebinding accounts for the presentation mode
when switching accounts or toggling Local Premium.

## Reconciliation R3

Baseline `4580a1b60`. Resolved the grouped-photo rebuild and superseded the
legacy WAV patch, leaving 33 deferred historical entries. Grouped send
workers consume paths after the synchronous rebuild. Its decoded and
composited bitmaps never leave that rebuild. The prior edited file remains
available if decoding, cropping or writing fails, and can still be read by
other users of the cloned entry's path.

Media3 keeps PCM and float PCM in its raw-audio path, decodes IMA ADPCM to
PCM in the extractor, and emits A-law and mu-law samples with their own MIME
types for decoder selection. The FFmpeg renderer maps those sample types and
checks whether the decoder was actually compiled. Unknown WAV encodings stay
unsupported by the extractor. Device checks remain for PCM widths, float,
extensible PCM, RF64, IMA ADPCM, G.711 and malformed input. Outgoing WAV uses
Android's metadata retriever when it can read a duration.

Avatar work remains deferred. The small-vector path needs explicit binding
identity, owner comparison, account- and mode-aware reuse, and a visible
thumbnail rebind on Local Premium changes. None of those should change
other users' fetch or animation eligibility.

## Reconciliation R4

Baseline `c71a0b190`. Resolved three historical entries, leaving 30 deferred.
Dialog and chat avatar binds now pass the cell account. Profile galleries and
vector artwork loaders also use their owning account. Local presentation
requires an exact nonzero self ID match, the existing Local Premium
preference, cached vector markup and permission to animate in that context.
The preference keeps its existing global storage. Locally configured users
seen as peers of another binding account retain their genuine Premium
presentation. Drawable reuse checks the account and effective small-avatar
mode. Existing media cache keys and profile-size rendering remain in place.

Visible self thumbnails and self table badges observe the existing
`premiumStatusChangedGlobal` notification through view-scoped listeners,
and refresh when reattached. A table row still gives emoji status precedence
over the badge. The composer portion of `e035a9b9f` remains deferred.

## Reconciliation R5

Baseline `d87fd0d79`. Six deferrals resolved, leaving 24. Java app-config
uses the existing per-account update tick and cache-backed periodic checks.
Initialization and Telegram config updates retain forced refresh. A force
arriving during a load is coalesced into one follow-up. A missing or unreadable
cache row reaches remote fetch with hash zero. Native datacenter recovery,
DNS fallbacks and JNI are unchanged.

The Optogram 13.1.1 worktree at `6ddae5097` keeps Telegram's own
`help.getAppUpdate` handler and standalone prompts. R5 follows that split and
removes Forkgram release discovery, UI, dynamic receiver, download and
installation paths, and cached installer cleanup. No custom manifest entry
existed. Telegram's shared APK provider, installation permission, update
notification, file-reference refresh and pending-update recovery stay in use.
Forkgram previously wrote optional update records into the same Telegram
store without a source marker. R5 removes that producer and preserves
ambiguous existing records under Telegram's existing validity rules.

Last.fm remains deferred. Its now-playing and scrobbling callbacks,
settings and deep link, backup namespace, credential build inputs and
resources remain active. The standalone store listing and wording
deferrals remain open.

## Reconciliation R6

Baseline `83ea32c8a`. Resolved four historical deferrals, leaving 20. The
direct Optogram release listing has its own English and Russian text. Root
metadata and the F-Droid app label still match the separate Forkgram
distribution. The sponsored-message toggle and settings-lock strings
retain their existing behavior. Launcher artwork was already represented.

Last.fm now-playing and scrobbling hooks were isolated from playlist
progression, media metadata, focus and notification code. Removal includes
authentication and session tasks, the setting and deep link, the icon,
the empty section header and build inputs. Older backup files remain
readable under the existing marker. Restore skips the retired namespace
before parsing its content, and export excludes it. Credentials already on
disk are unused. No migration or manifest change was needed.

The historical ExoPlayer buffer patch has no safe counterpart in the
current Media3 ownership model. Tablet initialization and the mixed
historical build workaround remain deferred. Tablet work needs a
reproducible failure. The build workaround touches networking, signing,
variants and entitlement outside this batch.
