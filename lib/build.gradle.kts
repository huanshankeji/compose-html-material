plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    id("org.jetbrains.compose") version "1.1.1"
    id("com.huanshankeji.sonatype-ossrh-publish")
}

kotlin {
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                implementation(npm("@webcomponents/webcomponentsjs", DependencyVersions.webcomponents))

                fun mwcImplementation(module: String) =
                    implementation(npm("@material/mwc-$module", DependencyVersions.mwc))

                fun mwcImplementations(vararg modules: String) {
                    for (module in modules) mwcImplementation(module)
                }

                mwcImplementations(
                    "button",
                    "textfield",
                    "select",
                    "icon-button",
                    "snackbar",
                    "circular-progress",
                    "circular-progress-four-color"
                )

                implementation(npm("@material/card", DependencyVersions.mdc))
            }
        }
    }
}

//group = "com.huanshankeji"
version = projectVersion

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing.publications.withType<MavenPublication> {
    artifact(javadocJar)
}
