import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation(project(":compose-web-common"))

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

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose for Web Material",
        "Some Material components for Compose for Web"
    ) {
        `Shreck Ye`()
    }
}
