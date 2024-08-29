plugins {
    `kotlin-dsl`
}
repositories {
    //mavenLocal()
    gradlePluginPortal()
    //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val huanshankejiGradlePluginsVersion = "0.5.1"

dependencies {
    // With Kotlin 2.0.20, a "Could not parse POM" build error occurs in the JVM projects of some dependent projects.
    val kotlinVersion = "2.0.10"
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.6.10")
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji.team:gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji:common-gradle-dependencies:0.7.1-20240516")
}
