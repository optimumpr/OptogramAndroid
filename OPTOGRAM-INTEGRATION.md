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
