# Copilot Instructions for compose-html-material

## Project Overview

This repository provides **Material 3 wrapper components for Compose HTML** based on [Material Web](https://github.com/material-components/material-web). It's a Kotlin Multiplatform library targeting JavaScript/Browser, allowing developers to use Material Design 3 components in Compose HTML applications.

**Key Points:**
- **Type:** Kotlin/JS library (not an application)
- **Size:** Small to medium (~3 main modules)
- **Language:** Kotlin 2.1.0
- **Frameworks:** Compose HTML 1.7.1, Kobweb 0.20.0
- **Build System:** Gradle 9.0.0 with Kotlin DSL
- **Target Runtime:** JavaScript/Browser (Kotlin/JS)
- **Published to:** Maven Central

## Project Structure

### Root Directory Files
- `build.gradle.kts` - Root build configuration (Dokka, API validation)
- `settings.gradle.kts` - Multi-module project settings
- `gradle.properties` - Dokka V2 configuration
- `gradlew` / `gradlew.bat` - Gradle wrapper scripts
- `CONTRIBUTING.md` - Development guidelines
- `README.md` - User documentation
- `CHANGELOG.md` - Version history

### Main Modules
1. **`compose-html-common`** - Common utilities and attributes for Compose HTML
   - Location: `/compose-html-common/`
   - Source: `src/jsMain/kotlin/com/huanshankeji/compose/web/`
   - Key packages: `attributes`, `css`, layouts

2. **`compose-html-material3`** - Material 3 component wrappers (primary module)
   - Location: `/compose-html-material3/`
   - Source: `src/jsMain/kotlin/com/huanshankeji/compose/html/material3/`
   - Components: MdButton, MdCheckbox, MdIcon, MdTextField, MdMenu, MdProgress, etc.
   - Depends on: `compose-html-common`, npm package `@material/web`

3. **`compose-html-material-legacy`** - Legacy Material 2 components (no longer actively maintained)
   - Location: `/compose-html-material-legacy/`

4. **`gradle-plugins`** - Legacy gradle plugins
   - Location: `/gradle-plugins/`
   - Published as: `compose-html-material-gradle-plugins-legacy`

5. **`buildSrc`** - Build logic and convention plugins
   - Location: `/buildSrc/`
   - Key file: `src/main/kotlin/VersionsAndDependencies.kt` - contains version constants
   - Convention plugins: `lib-conventions.gradle.kts`, `lib-conventions-without-publishing.gradle.kts`

### Important Configuration Files
- **API validation:** Each published module has an `api/` directory with `.klib.api` files for binary compatibility checking
- **Kotlin/JS store:** `kotlin-js-store/yarn.lock` - JavaScript dependencies cache
- **Site generation:** `site/` directory contains static files for documentation site

## Build & Validation Commands

### Environment Requirements
- **JDK 17** (Temurin distribution recommended) - CRITICAL: The CI uses JDK 17, always ensure compatibility
- **Gradle 9.0.0** (via wrapper, automatically downloaded)
- **Internet access** for downloading dependencies from:
  - Maven Central
  - `https://maven.pkg.jetbrains.space/public/p/compose/dev` (Compose dependencies)
  - `https://us-central1-maven.pkg.dev/varabyte-repos/public` (Kobweb dependencies)

### CRITICAL: Network Dependencies
This project requires external repositories that may not be accessible in restricted environments. If you encounter DNS resolution errors (e.g., "No address associated with hostname") for `maven.pkg.jetbrains.space` or `us-central1-maven.pkg.dev`, builds will fail. These are known limitations in sandboxed environments.

### Build Commands

**IMPORTANT:** Always use `./gradlew` (or `gradlew.bat` on Windows), never install Gradle separately.

1. **Check/Test (Primary validation)**
   ```bash
   ./gradlew check
   ```
   - Runs all checks including API validation
   - This is the main command used in CI
   - Expected time: 1-3 minutes (after initial setup)
   - No unit tests exist currently; this primarily validates compilation and API compatibility

2. **Build All Modules**
   ```bash
   ./gradlew build
   ```
   - Compiles all modules
   - Generates artifacts in each module's `build/` directory

3. **Publish to Maven Local** (for testing changes locally)
   ```bash
   ./gradlew publishToMavenLocal
   ```
   - Publishes artifacts to `~/.m2/repository/`
   - Use this to test your changes in dependent projects

4. **Generate API Documentation Site**
   ```bash
   ./gradlew generateSite
   ```
   - Generates Dokka documentation
   - Output: `build/site/` directory
   - Used by GitHub Pages deployment workflow

5. **Clean Build**
   ```bash
   ./gradlew clean build
   ```
   - Removes all build artifacts first
   - Use when troubleshooting build issues

### Build Timing Notes
- **First build:** 3-10 minutes (downloads Gradle, dependencies, builds buildSrc)
- **Subsequent builds:** 30 seconds - 2 minutes
- **Clean builds:** 1-3 minutes

### Common Build Issues & Solutions

1. **Gradle Daemon startup delays**: First build in a session takes longer while Gradle daemon starts. Subsequent builds are much faster.

2. **Kotlin compiler warnings about version mismatch**: You may see warnings like "WARNING: Unsupported Kotlin plugin version" in the buildSrc compilation. These are typically non-fatal and relate to the Kotlin version mismatch between buildSrc (2.1.0) and Gradle's embedded Kotlin (2.2.0).

3. **Network/dependency resolution failures**: Builds WILL fail in environments without access to the required Maven repositories. There is no workaround other than ensuring network access.

## CI/CD Workflows

### Location
`.github/workflows/`

### Workflows

1. **`kotlin-multiplatform-ci.yml` (Main CI)**
   - **Trigger:** Push to any branch, manual dispatch
   - **Jobs:**
     - `test-and-check`: Runs `./gradlew check` with JDK 17
     - `dependency-submission`: Submits dependency graph to GitHub
   - **Action:** Uses `huanshankeji/.github/actions/gradle-test-and-check@v0.2.0`
   - **CRITICAL:** Your code changes MUST pass `./gradlew check` locally before pushing

2. **`site-gh-pages.yml` (Documentation Deployment)**
   - **Trigger:** Push/PR to `release` branch, manual dispatch
   - **Job:** Builds and deploys documentation site to GitHub Pages
   - **Build command:** `./gradlew generateSite`
   - **Output:** `build/site/` uploaded to GitHub Pages

### Validation Before Commit
To replicate CI locally:
```bash
./gradlew clean check
```

This ensures:
- All modules compile successfully
- API compatibility is maintained (binary compatibility validator)
- No breaking changes to public APIs

## Development Workflow

### Making Code Changes

1. **Before starting:**
   - Check which module your change affects (usually `compose-html-material3` or `compose-html-common`)
   - Review existing similar components for patterns and conventions

2. **After making changes:**
   - Run `./gradlew check` to validate
   - If adding new public APIs, run `./gradlew apiDump` to update `.klib.api` files
   - If changing existing APIs, review `.klib.api` diffs carefully (breaking changes require version bumps)

3. **Testing changes locally:**
   - Use `./gradlew publishToMavenLocal`
   - Create/update a test project that depends on `com.huanshankeji:compose-html-material3:0.4.1-SNAPSHOT`
   - Verify the component works in a real Compose HTML application

### API Compatibility
This project uses Kotlin's binary compatibility validator (`kotlinx.validation`):
- Public API signatures are tracked in `api/*.klib.api` files
- Breaking changes will fail the `check` task
- To update API files after intentional changes: `./gradlew apiDump`
- ALWAYS review API changes carefully before committing

### Version Management
- Current version defined in: `buildSrc/src/main/kotlin/VersionsAndDependencies.kt`
- Current version: `0.4.1-SNAPSHOT`
- Release versions should not have `-SNAPSHOT` suffix

## Code Conventions & Patterns

### Component Structure
Material 3 components follow a consistent pattern (see `compose-html-material3/src/jsMain/kotlin/com/huanshankeji/compose/html/material3/`):

```kotlin
// Common pattern for Material Web components
@Composable
fun MdComponentName(
    disabled: Boolean? = null,
    // ... component-specific parameters
    attrs: Attrs<HTMLElement>? = null,
    content: (@Composable ElementScope<HTMLElement>.() -> Unit)? = null
) {
    TagElement("md-component-name", {
        disabled(disabled)
        // ... set attributes
        attrs?.invoke(this)
    }, content)
}
```

### Key Patterns
1. **Nullable parameters** for optional attributes (not defaulting to false/empty)
2. **Attrs parameter** for custom attributes (always nullable, applied last)
3. **Content lambda** for component children (nullable, last parameter)
4. **kebab-case** for HTML element names (e.g., `md-elevated-button`)
5. **Extension functions** in `compose-html-common` for common attribute patterns

### File Organization
- One component type per file (e.g., `MdButton.kt` contains all button variants)
- Attributes extensions in `attributes/` subdirectory
- Common utilities in `compose-html-common` module

## Dependencies

### Key Dependencies
- **Kotlin:** 2.1.0
- **Compose Multiplatform:** 1.7.1
- **Kobweb:** 0.20.0 (provides Compose HTML extensions)
- **Material Web:** 2.2.0 (NPM dependency)
- **Dokka:** 2.0.0-Beta (documentation generation)

### Adding Dependencies
Dependencies are declared in module `build.gradle.kts` files using the convention:
```kotlin
kotlin {
    sourceSets {
        jsMain {
            dependencies {
                implementation(project(":compose-html-common"))
                implementation(npm("package-name", "version"))
            }
        }
    }
}
```

Version constants should be added to `buildSrc/src/main/kotlin/VersionsAndDependencies.kt`.

## Testing

**IMPORTANT:** This project currently has NO automated tests. The validation relies on:
1. Successful compilation
2. API compatibility checking
3. Manual testing via `publishToMavenLocal`

When adding components:
- Manually test in a real Compose HTML application
- Verify component renders correctly in a browser
- Test attribute bindings and event handlers
- Check Material Symbols/Icons display correctly (requires separate setup)

## Common Tasks Reference

| Task | Command | When to Use |
|------|---------|-------------|
| Validate all changes | `./gradlew check` | Before every commit |
| Build everything | `./gradlew build` | Verify all modules compile |
| Clean build | `./gradlew clean build` | Troubleshooting |
| Update API signatures | `./gradlew apiDump` | After public API changes |
| Test locally | `./gradlew publishToMavenLocal` | Test changes in other projects |
| Generate docs | `./gradlew generateSite` | Update documentation site |
| List all tasks | `./gradlew tasks` | Discover available tasks |

## Troubleshooting

### Build fails with "Could not resolve dependency"
- Ensure internet connectivity
- Check that all required Maven repositories are accessible
- Try `./gradlew build --refresh-dependencies`

### API check fails after changes
- Review the API diff: `git diff */api/*.klib.api`
- If changes are intentional: `./gradlew apiDump` to update
- If changes are breaking, consider if version bump is needed

### Gradle daemon issues
- Stop daemon: `./gradlew --stop`
- Clear cache: `rm -rf ~/.gradle/caches/` (last resort)

## Important Notes

1. **ALWAYS run `./gradlew check` before committing** to catch issues early
2. **Never commit changes to `.gradle/`, `build/`, `.kotlin/`, or `.idea/` directories** (already in .gitignore)
3. **This is a library, not an application** - there's no main method or runnable app
4. **Material 2 components are legacy** - focus work on Material 3 (`compose-html-material3`)
5. **Trust these instructions first** - only search/explore if information here is incomplete or incorrect
