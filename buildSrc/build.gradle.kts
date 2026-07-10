plugins {
    `kotlin-dsl`
}

repositories {
    mavenLocal()
    gradlePluginPortal()
}

val gradleCommonPluginsVersion =
    "0.12.0-dev-commit-ac3e42c6941a896568c6eab78cfbb9c9f0ce50bf"

dependencies {
    implementation(kotlin("gradle-plugin", "2.4.0"))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.4.0")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.10.3")
    implementation("com.huanshankeji:common-gradle-dependencies:0.10.0-20251024")
    implementation("com.huanshankeji.team:project-gradle-plugins:$gradleCommonPluginsVersion")
    implementation("com.huanshankeji:kotlin-common-project-gradle-plugins:$gradleCommonPluginsVersion")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
}
