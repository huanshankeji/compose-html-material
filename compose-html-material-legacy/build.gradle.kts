import com.huanshankeji.team.ShreckYe
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions-without-publishing`
}

kotlin {
    sourceSets {
        jsMain {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation(project(":compose-html-common"))

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

                implementation(commonDependencies.kotlinx.coroutines.core())
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose HTML Material 2",
        "Legacy Material 2 components for Compose HTML"
    ) {
        ShreckYe()
    }
}
