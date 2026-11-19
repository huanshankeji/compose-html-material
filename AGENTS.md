# Repository Guidelines

Before working in this repository, **load and read** the [Huanshankeji general agent instructions](https://github.com/huanshankeji/.github/blob/main/docs/general-agent-instructions.md) as the required organization-wide baseline. A skipped or failed load, or an unread document, is a blocking error until the document is in context and has been read. Follow the baseline's task-specific reading requirements.

## Project Structure

- `compose-html-material3/` wraps Material Web components for Compose HTML. `compose-html-common/` holds shared DOM, attribute, and CSS helpers.
- `compose-html-material3-maicol07-material-web-additions/` wraps additional components, including snackbar and top app bars. Its API lives under `com.huanshankeji.compose.html.material3.maicol07.materialwebadditions` and uses `@MaterialWebAdditionsApi`. Kotlin/JS library sources live in each module’s `src/jsMain/kotlin/`. Public ABI snapshots live in `api/`.
- `buildSrc/` contains shared Gradle conventions, and `site/` holds the static documentation landing page. Focus work on the maintained Material 3 libraries. Keep the [unmaintained Material 2 module](CONTRIBUTING.md#development) frozen and direct users who need Material 2 to KMDC as described in [README.md](README.md). `gradle-plugins/` and `legacy/` contain legacy code or assets.

## Build and Development

Use the Gradle wrapper from the repository root and JDK 17, matching CI. If `*-dev-commit-*` dependencies are not in Maven Local, configure `gpr.user` and `gpr.key` in `~/.gradle/gradle.properties` as described in [CONTRIBUTING.md](CONTRIBUTING.md). Never commit credentials.

- `./gradlew build` assembles and verifies the project; `./gradlew check` runs verification without assembling distributions.
- Run `./gradlew checkKotlinAbi` to compare the current ABI with the tracked reference snapshots. For intentional ABI changes, run `./gradlew updateKotlinAbi` and review the generated diff before including the updated snapshots. See [Kotlin’s ABI validation guide](https://kotlinlang.org/docs/gradle-binary-compatibility-validation.html).
- `./gradlew publishToMavenLocal` makes local builds available to a downstream Compose HTML app for browser testing.
- `./gradlew :generateSite` combines `site/` with Dokka output in `build/site/` for local preview.

## Kotlin Style

Use four spaces and match surrounding Kotlin and Gradle Kotlin DSL formatting. Use `@JsModule` imports for JavaScript modules to support the ES2015 compilation target.

## Material Web Wrappers

- Use the `Md` prefix and keep variants of one component family in the same file, such as `MdButton.kt`. Render custom elements with `TagElement` and the upstream kebab-case tag name.
- Follow the attribute order in the upstream component documentation. Use upstream source order for Labs components without documented attributes. Use nullable arguments with `null` defaults for optional attributes so the element can apply its defaults.
- Use `attrs: AttrBuilderContext<HTMLElement>? = null` for custom attributes, with the component's element type where appropriate. Apply it after the wrapper's built-in attributes. Keep attribute extensions under `attributes/` and reuse shared helpers from `compose-html-common`.
- Use `ContentBuilder` for children and put `content` last. Require callers to supply it for components whose expected usage needs children. Default it to `null` for optional children, such as a checkbox's ripple slot. Follow neighboring wrappers for whether a supplied lambda may be null and preserve existing signatures when editing wrappers.

### Upstream References

Use the upstream documentation and [Material Design 3 component guidance](https://m3.material.io/components/) to check behavior and design. In component KDoc, link to the relevant Material Web documentation, demo, stories, and Material Design guidance where available. Verify the links when adding them. For a parameter or slot absent from upstream docs, put a GitHub permalink to the exact lines of source, demo, or story that show it immediately before the parameter or slot.

## Verification

There are no checked-in test source sets or coverage thresholds. Run `./gradlew :compose-html-material3:check` for a targeted check, then `./gradlew check` for cross-module changes.

For UI changes, publish the local build and use its published coordinates in a real Compose HTML app, such as the [Compose Multiplatform HTML Unified demo](https://github.com/huanshankeji/compose-multiplatform-html-unified). Verify affected rendering, attribute bindings, and events. When icons are involved, check them with the [Material Symbols setup](README.md#material-symbols--icons). Record the browser repro steps.

## Commits and Pull Requests

Use concise, imperative subjects, such as `Add a missing space`. Discuss substantial changes in an issue or GitHub Discussion first. In the PR, explain the change, link any related issue, report verification results, and include screenshots for visible changes when useful.
