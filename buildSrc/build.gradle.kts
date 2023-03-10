plugins {
    `kotlin-dsl`
}
repositories {
    mavenLocal()
    gradlePluginPortal()
    //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val kotlinVersion = "1.8.10"
val huanshankejiGradlePluginsVersion = "0.4.0"

dependencies {
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.3.1")
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji.team:gradle-plugins:$huanshankejiGradlePluginsVersion")
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}
