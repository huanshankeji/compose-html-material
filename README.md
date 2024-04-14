# Compose HTML Material

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-html-material)](https://search.maven.org/artifact/com.huanshankeji/compose-html-material)
[![Gradle Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/com.huanshankeji.compose-html-material-conventions)](https://plugins.gradle.org/plugin/com.huanshankeji.compose-html-material-conventions)

Some Material components for Compose HTML, with legacy Material 2 wrapper components based on [the obsolete `mwc` branch of Material Web](https://github.com/material-components/material-web/tree/mwc) (preferred) and [Material Components for the web (or material-components-web, or `mdc`)](https://github.com/material-components/material-components-web) (fallback), and Material 3 wrapper components based on [Material Web](https://github.com/material-components/material-web)

~~This project is in prototype and the components are not complete. More components will be added. It will probably go through huge refactors and API changes, too.~~

**The Material 2 portion of this project is not currently under active development. Here is a list of reasons and alternatives:**

1. The [material-web](https://github.com/material-components/material-web) team is working on Material 3 support and [the Material 2 branch (`mwc`)](https://github.com/material-components/material-web/tree/mwc) is no longer under active development. Existing Compose wrappers of their Material 2 components are still kept in [the `:compose-html-material` subproject](compose-html-material) but not updated.
1. [KMDC](https://github.com/mpetuska/kmdc) wrapping around [material-components-web (`mdc`)](https://github.com/material-components/material-components-web) provides a much more complete set of Material Design components for Compose HTML.
1. We are currently focusing more on [compose-multiplatform-material](https://github.com/huanshankeji/compose-multiplatform-material) to provide multiplatform Compose Material wrappers, whose web portion depends on KMDC and [the `:compose-html-common` subproject](compose-html-common), which may be occasionally updated for the dependent project.

## Instructions on how to use

Some configurations are needed to use this library due to the immaturities of this project and Kotlin/JS.

### Add the dependency

Prior to v0.3.0:

```kotlin
implementation("com.huanshankeji:compose-web-material:$version")
```

Since v0.3.0:

```kotlin
implementation("com.huanshankeji:compose-html-material:$version")
```

### In code

Call `mwcRequires()` in your `main` function before calling any component Composable functions.

### Kotlin/JS Webpack configuration

If you use this library in an app project with Webpack [which Kotlin/JS currently uses](https://kotlinlang.org/docs/js-project-setup.html), you might want to configure it as recommended by Material Web and Material Components for the web. Some instructions on how to do this simply are as below.

If you use a version prior to v0.3.0, this plugin helps add the dependency to this project (if you do this you can skip the "Add the dependency" step above) and the `devNpm` dependencies:

```kotlin
plugins {
    id("com.huanshankeji.compose-web-material-conventions") version someVersion
}
```

However, the plugin doesn't [make further adjustments to the webpack configuration](https://kotlinlang.org/docs/js-project-setup.html#webpack-configuration-file), so you also need to refer to [the demo further adjustments](demo/webpack.config.d/further_adjustments.js) and [the demo HTML page](demo/html/demo.html) to add your own. Just copy and possibly adapt them as you like.
