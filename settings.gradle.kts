pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

plugins {
    id("public-open-source-dependency-repositories") version
        "0.12.0-dev-commit-7fe538f8906aa9460a73cd32390005180fab633e"
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
