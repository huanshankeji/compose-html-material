rootProject.name = "compose-html-material"

include("compose-html-common")
include("compose-html-material-legacy")
include("compose-html-material3")
include("compose-html-material3-maicol07-material-web-additions")
include("gradle-plugins")
project(":gradle-plugins").name = "compose-html-material-gradle-plugins-legacy"

// for Dokka
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
