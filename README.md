# Compose HTML Material

[![Maven Central](https://img.shields.io/maven-central/v/com.huanshankeji/compose-html-material3)](https://search.maven.org/artifact/com.huanshankeji/compose-html-material3)

Material 3 wrapper components for Compose HTML based on [Material Web](https://github.com/material-components/material-web)

For unified multiplatform APIs which are more akin to those in `androidx.compose`, check out [Compose Multiplatform Material](https://github.com/huanshankeji/compose-multiplatform-material) which also depends on this library. Also see its [the side-by-side demo site](https://huanshankeji.github.io/compose-multiplatform-material/) for the visual effects of the components.

For Material 2 support, you are recommended to check out [KMDC](https://github.com/mpetuska/kmdc) instead. For information on our obsolete work on legacy Material 2 components, check out [the legacy README](/legacy/README.md).

## Supported components

Not all components of Material Web are supported yet. Also, not all Material Design components are supported by Material Web yet (see [their roadmap](https://github.com/material-components/material-web/blob/main/docs/roadmap.md)).

Here is a list of supported compoent APIs:

- `MdElevatedButton`, `MdFilledButton`, `MdFilledTonalButton`, `MdOutlinedButton`, `MdTextButton`
- `MdCheckbox`
- `MdFab`, `MdBrandedFab`
- `MdIcon`
- `MdIconButton`, `MdFilledIconButton`, `MdFilledTonalIconButton`, `MdOutlinedIconButton`
- `MdList`, `MdListItem`
- `MdMenu`, `MdMenuItem`, `MdSubMenu`
- `MdLinearProgress`, `MdCircularProgress`
- `MdSwitch`, `LabelWithMdSwitch`
- `MdFilledTextField`, `MdOutlinedTextField`

### "labs" components

Here is a list of supported component APIs in the [Material Web "labs" directory](https://github.com/material-components/material-web/tree/main/labs), which "contains experimental features that are not recommended for production" as they state:

- `MdElevatedCard`, `MdOutlinedCard`
- `MdNavigationBar`
- `MdNavigationTab`

You should opt-in to `@MaterialWebLabsApi` to use them.

## Brief Instructions

### Add the dependency

With Gradle:

```kotlin
kotlin {
    sourceSets {
        jsMain {
            dependencies {
                // ...
                implementation("com.huanshankeji:compose-html-material3:$version")
            }
        }
    }
}
```

This project depends on [Kobweb](https://github.com/varabyte/kobweb) which is not published to Maven Central yet, so you have to add the following Maven repository:

```kotlin
repositories {
    mavenCentral()
    maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
}
```

### Material Symbols & Icons

The Material 3 module uses [Material Symbols & Icons](https://fonts.google.com/icons), but doesn't depend on the stylesheet directly. For Material Icons to work properly, you may need to configure your project following the quick instructions below or [the developer guide](https://developers.google.com/fonts/docs/material_symbols).

#### Quick instructions

In short, there are 3 ways to add the Material Symbols & Icons dependency:

1. Add the stylesheet hosted by Google directly in your HTML file `head`:

   ```html
   <link href="https://fonts.googleapis.com/icon?family=Material+Symbols+Outlined" rel="stylesheet">
   ```

1. Use [Marella's self-hosted Material Symbols](https://www.npmjs.com/package/material-symbols).

   First add the dependency in your build script:

   ```kotlin
   implementation(npm("material-symbols", "0.17.4"))
   ```

   And then import the icons in your program. For example you can use CommonJS `require`:

   ```kotlin
   external fun require(module: String): dynamic
   fun main() {
       require("material-symbols/outlined.css")
       renderComposableInBody { App() }
   }
   ```

   If you are familiar with web development and Kotlin/JS, you can depend on the stylesheet in any way that works and you prefer. For example, you can use `@JsModule` corresponding to the UMD import, or configure it as a Webpack entry point. See the following docs fore more details:
   1. [JavaScript modules | Kotlin Documentation](https://kotlinlang.org/docs/js-modules.html)
   1. [the "webpack configuration file" section in Set up a Kotlin/JS project | Kotlin Documentation](https://kotlinlang.org/docs/js-project-setup.html#webpack-configuration-file)
   1. [Code Splitting | webpack](https://webpack.js.org/guides/code-splitting/)
   1. [Advanced entry | webpack](https://webpack.js.org/guides/entry-advanced/)

1. [Download and self-host the latest font](https://developers.google.com/fonts/docs/material_symbols#self-hosting_the_font).
