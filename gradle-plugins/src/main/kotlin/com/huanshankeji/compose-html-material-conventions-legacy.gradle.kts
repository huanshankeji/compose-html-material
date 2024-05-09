package com.huanshankeji

import projectVersion

plugins {
    kotlin("multiplatform")
}

kotlin {
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation("com.huanshankeji:compose-html-material-legacy:$projectVersion")

                implementation(devNpm("css-loader", NpmDevDependencyVersions.cssLoader))
                implementation(devNpm("extract-loader", NpmDevDependencyVersions.extractLoader))
                implementation(devNpm("file-loader", NpmDevDependencyVersions.fileLoader))
                implementation(devNpm("sass", NpmDevDependencyVersions.sass))
                implementation(devNpm("sass-loader", NpmDevDependencyVersions.sassLoader))
            }
        }
    }
}
