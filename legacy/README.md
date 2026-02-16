# Compose HTML Material (legacy Material 2)

> [!WARNING]
> **This module is obsolete and NO LONGER MAINTAINED.**
> 
> - No bug fixes, updates, or improvements will be made to this module
> - For Material 2 components, please use [KMDC](https://github.com/mpetuska/kmdc) instead
> - For Material 3 components, use the main `compose-html-material3` module

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-html-material-legacy)](https://search.maven.org/artifact/com.huanshankeji/compose-html-material-legacy)
[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/com.huanshankeji.compose-html-material-conventions-legacy)](https://plugins.gradle.org/plugin/com.huanshankeji.compose-html-material-conventions-legacy)

Some legacy Material 2 components for Compose HTML, based on [the obsolete `mwc` branch of Material Web](https://github.com/material-components/material-web/tree/mwc) (preferred) and [Material Components for the web (or material-components-web, or `mdc`)](https://github.com/material-components/material-components-web) (fallback)

**There will be no further development effort in this legacy Material 2 portion of this project. Here is a list of reasons and alternatives:**

1. The [material-web](https://github.com/material-components/material-web) team is working on Material 3 support and [the Material 2 branch (`mwc`)](https://github.com/material-components/material-web/tree/mwc) is no longer under active development. Existing Compose wrappers of their Material 2 components are still kept in [the `:compose-html-material-legacy` subproject](/compose-html-material-legacy) but not updated.
1. [KMDC](https://github.com/mpetuska/kmdc) wrapping around [material-components-web (`mdc`)](https://github.com/material-components/material-components-web) provides a much more complete set of Material Design components for Compose HTML.

## Instructions on how to use

Some configurations are needed to use this library due to the immaturities of this project and Kotlin/JS.

### Add the dependency

Prior to v0.3.0:

```kotlin
implementation("com.huanshankeji:compose-web-material:$version")
```

Since v0.3.0:

```kotlin
implementation("com.huanshankeji:compose-html-material-legacy:$version")
```

### In code

Call `mwcRequires()` in your `main` function before calling any component Composable functions.

### Kotlin/JS Webpack configuration

If you use this library in an app project with Webpack [which Kotlin/JS currently uses](https://kotlinlang.org/docs/js-project-setup.html), you might want to configure it as recommended by Material Web and Material Components for the web. Some instructions on how to do this simply are as below.

If you use a version prior to v0.3.0, this plugin helps add the dependency to this project (if you do this you can skip the "Add the dependency" step above) and the `devNpm` dependencies:

Prior to v0.3.0:

```kotlin
plugins {
    id("com.huanshankeji.compose-web-material-conventions") version someVersion
}
```

Since v0.3.0:

```kotlin
plugins {
    id("com.huanshankeji.compose-web-material-conventions-legacy") version someVersion
}
```

However, the plugin doesn't [make further adjustments to the webpack configuration](https://kotlinlang.org/docs/js-project-setup.html#webpack-configuration-file), so you also need to refer to [the demo further adjustments](demo/webpack.config.d/further_adjustments.js) and [the demo HTML page](demo/html/demo.html) to add your own. Just copy and possibly adapt them as you like.

Also note that there is [a new approach to adding CSS and SCSS support in the Kotlin Gradle Plugin since 1.8](https://kotlinlang.org/docs/whatsnew18.html#new-approach-to-adding-css-support-to-your-project), which replaces the function of this plugin.
