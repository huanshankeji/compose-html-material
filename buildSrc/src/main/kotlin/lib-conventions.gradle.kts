plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    id("org.jetbrains.compose")
    id("com.huanshankeji.kotlin-multiplatform-sonatype-ossrh-publish-conventions")
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

group = "com.huanshankeji"
version = projectVersion
