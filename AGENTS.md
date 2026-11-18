# Repository Guidelines

Agents must read the [Huanshankeji agent instructions](https://github.com/huanshankeji/.github/blob/main/docs/general-agent-instructions.md) and follow their task-specific reading requirements before working on this repository.

## Project Structure

- `compose-html-material3/` wraps Material Web components for Compose HTML. `compose-html-common/` holds shared DOM, attribute, and CSS helpers.
- `compose-html-material3-maicol07-material-web-additions/` wraps additional components, including snackbar and top app bars. Kotlin/JS library sources live in each module’s `src/jsMain/kotlin/`; public ABI snapshots live in `api/`.
- `buildSrc/` contains shared Gradle conventions, and `site/` holds the static documentation landing page. The Material 2 module (`compose-html-material-legacy/`), `gradle-plugins/`, and `legacy/` contain legacy code or assets; focus new work on the maintained libraries.

## Build and Development

Use the Gradle wrapper from the repository root and JDK 17, matching CI. If `*-dev-commit-*` dependencies are not in Maven Local, configure `gpr.user` and `gpr.key` in `~/.gradle/gradle.properties` as described in [CONTRIBUTING.md](CONTRIBUTING.md). Never commit credentials.

- `./gradlew build` assembles and verifies the project; `./gradlew check` runs verification without assembling distributions.
- `./gradlew publishToMavenLocal` makes local builds available to a downstream Compose HTML app for browser testing.
- `./gradlew :generateSite` combines `site/` with Dokka output in `build/site/` for local preview.

## Kotlin Style

Use four spaces and match surrounding Kotlin and Gradle Kotlin DSL formatting. Name component wrappers and files after the upstream component, using the `Md` prefix (`MdCheckbox` in `MdCheckbox.kt`). Use `@JsModule` imports rather than `require()`. Reuse shared attribute helpers and follow nearby wrappers for `attrs` and `content` parameters.

## Verification

There are no checked-in test source sets or coverage thresholds. Run `./gradlew :compose-html-material3:check` for a targeted check, then `./gradlew check` for cross-module changes. Review ABI differences for public API changes. For UI changes, verify affected rendering and interactions in a downstream app and record the browser repro steps.

## Commits and Pull Requests

Use concise, imperative subjects, such as `Add a missing space`. Discuss substantial changes in an issue or GitHub Discussion first. In the PR, explain the change, link any related issue, report verification results, and include screenshots for visible changes when useful.
