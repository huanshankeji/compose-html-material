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
    implementation(kotlin("gradle-plugin", "1.9.25"))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.7.3")
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji.team:gradle-plugins:$huanshankejiGradlePluginsVersion")
    implementation("com.huanshankeji:common-gradle-dependencies:0.7.1-20240314")
}
