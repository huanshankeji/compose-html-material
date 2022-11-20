rootProject.name = "compose-web-material"
include("lib")
project(":lib").name = rootProject.name
include("gradle-plugins")
project(":gradle-plugins").name = rootProject.name + "-gradle-plugins"

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        //maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.7.20"))
        classpath("com.huanshankeji:kotlin-common-gradle-plugins:0.1.8-kotlin-1.6.10")
    }
}
