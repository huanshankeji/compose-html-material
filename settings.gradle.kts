pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

plugins {
    id("public-open-source-dependency-repositories") version
        "0.12.0-dev-commit-b1d2ff00e3ad91229d65136b8735ad189f2b0262"
}

publicOpenSourceDependencyRepositories {
    huanshankejiMavenLocal()
    githubPackages("compose-html-material", "kotlin-common", "gradle-common")
    mavenCentralExcludingHuanshankejiNonStable()
}

rootProject.name = "compose-html-material"

include("compose-html-common")
include("compose-html-material-legacy")
include("compose-html-material3")
include("compose-html-material3-maicol07-material-web-additions")
include("gradle-plugins")
project(":gradle-plugins").name = "compose-html-material-gradle-plugins-legacy"
