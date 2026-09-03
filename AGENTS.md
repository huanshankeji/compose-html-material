See [Copilot instructions](.github/copilot-instructions.md) for this repository.

Organization-wide standards and open-source library map: [@huanshankeji/.github general agent instructions](https://github.com/huanshankeji/.github/blob/main/docs/general-agent-instructions.md).

## Cursor Cloud specific instructions

This is a Kotlin/JS (Kotlin Multiplatform) **library**, not a runnable application. Standard build/validate commands are documented in `.github/copilot-instructions.md` (`./gradlew check`, `build`, `publishToMavenLocal`, `generateSite`). Non-obvious notes:

- **JDK:** CI uses JDK 17 (Temurin), but the cloud VM ships JDK 21, and `./gradlew check`/`build`/`publishToMavenLocal` all pass with it. The `apiCheck` validation is on Kotlin `.klib.api` files (JS target), so it is not affected by the JVM version.
- **No automated tests exist.** `jsBrowserTest`/`jsTest` are `SKIPPED`/`NO-SOURCE`; `check` validates compilation plus binary-compatibility (`apiCheck`). Do not auto-run `apiDump` (see copilot instructions).
- **Verifying components render (manual):** there is no app in this repo. Run `./gradlew publishToMavenLocal`, then consume `com.huanshankeji:compose-html-material3:0.5.0-SNAPSHOT` (repo `mavenLocal()`) from a standalone Compose HTML JS app (Kotlin 2.3.20, `org.jetbrains.compose` 1.10.3, JS target `es2015`) and run it with `jsBrowserDevelopmentRun` (webpack dev server on `http://localhost:8080/`).
- **Expected non-fatal warnings:** `publishToMavenLocal`/`generateSite` print `Failed to download package-list from https://docs.oracle.com/...` (Dokka external doc links) due to restricted egress; the build still succeeds.
