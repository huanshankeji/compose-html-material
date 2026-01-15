plugins {
    `kotlin-dsl`
}
repositories {
    //mavenLocal() // comment out when not needed
    gradlePluginPortal()
    //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    val kotlinVersion = "2.2.21"
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:$kotlinVersion")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.9.1")
    val huanshankejiGradlePluginsVersion = "0.11.0" // don't use a snapshot version in a main branch
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji.team:gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji:common-gradle-dependencies:0.10.0-20251024") // don't use a snapshot version in a main branch
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.1.0")
}
