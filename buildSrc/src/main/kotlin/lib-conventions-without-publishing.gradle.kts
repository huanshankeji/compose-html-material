plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
    id("com.huanshankeji.kotlin-multiplatform-sonatype-ossrh-publish-conventions")
}

repositories {
    mavenCentral()
    google()
}

group = "com.huanshankeji"
version = projectVersion
