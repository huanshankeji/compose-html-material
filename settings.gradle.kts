pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

plugins {
    id("public-open-source-dependency-repositories") version
        "0.12.0-dev-commit-e2dcb9d3d327edd99d80a6dfa041fc47c2db7bbb-dirty-SNAPSHOT"
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
