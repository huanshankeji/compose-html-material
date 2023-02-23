plugins {
    `kotlin-dsl`
}
repositories {
    //mavenLocal()
    gradlePluginPortal()
    //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val kotlinVersion = "1.8.0"

dependencies {
    implementation(kotlin("gradle-plugin", kotlinVersion))
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.3.0")
    implementation("com.huanshankeji:kotlin-common-gradle-plugins:0.3.2")
    implementation("com.huanshankeji.team:gradle-plugins:0.3.2")
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}
