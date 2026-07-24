plugins {
    id("com.huanshankeji.team.with-group")
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

version = providers.projectVersion()
