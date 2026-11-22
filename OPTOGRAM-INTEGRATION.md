# Optogram chronological integration

## Sequence

Use the original Optogram first-parent history after Forkgram 12.4.2
(`b55b00680`) through `optogram-security-2026-11-02^{commit}` (`d041fcba2`).
Use `main` and `integration/optogram-forkgram-base` as references for later
13.1.1 ports and fixes. Compare product behavior and file paths when matching
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
| `dce602cc4` | Change some icons | DEFERRED | Older default launcher PNGs need to be reconciled with the later Telegram artwork restoration and the current adaptive aliases. |
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
| `16ca13adb` | Improve default sync contacts to false | SKIPPED | 338a07ef1 already defaults sync off, including login state restore. Current UserConfig also defaults and clears it to false. The original patch precedes the first-login correction 1ca6a2e06. |
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
| `45c60f861` | Reset disconnect timeout on successful connection, commit by @tehcneko | DEFERRED | Native reconnect and Java app-config refresh behavior both need review. The later 650332534 covers only the native timeout reset. Check current retry and lifecycle behavior before importing either part. |
| `a557449fd` | fix some crashes | DEFERRED | The original leftBaseline change targets the old tablet initialization. Current code has a context guard, a cached tablet mode, and a user override. Revisit with a reproducible startup or layout failure. |
