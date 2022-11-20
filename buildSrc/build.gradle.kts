plugins {
    `kotlin-dsl`
}
repositories {
    //mavenLocal()
    gradlePluginPortal()
    //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.7.20"))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.2.1")
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:0.3.2")
    implementation("com.huanshankeji.team:gradle-plugins:0.3.2")
}
