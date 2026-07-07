import com.huanshankeji.gitversioning.projectVersionFromGitProvider

plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

version = projectVersionFromGitProvider(projectBaseVersion).get()
