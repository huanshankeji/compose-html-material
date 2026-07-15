import com.huanshankeji.gitversioning.devCommitVersionProvider

plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

version = providers.devCommitVersionProvider(projectBaseVersion).get()
