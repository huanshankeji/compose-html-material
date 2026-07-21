import com.huanshankeji.gitversioning.devCommitOrReleaseVersionProvider

plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

version = providers.devCommitOrReleaseVersionProvider(projectBaseVersion, isRelease).get()
