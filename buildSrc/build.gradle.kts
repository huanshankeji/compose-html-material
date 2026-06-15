plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    gradlePluginPortal()
}

val gradleCommonPluginsVersion =
    "0.12.0-dev-commit-e2dcb9d3d327edd99d80a6dfa041fc47c2db7bbb-dirty-SNAPSHOT"

dependencies {
    implementation(kotlin("gradle-plugin", "2.4.0"))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.4.0")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.10.3")
    implementation("com.huanshankeji:common-gradle-dependencies:0.10.0-20251024")
    implementation("com.huanshankeji.team:gradle-plugins:$gradleCommonPluginsVersion")
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:$gradleCommonPluginsVersion")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
}
