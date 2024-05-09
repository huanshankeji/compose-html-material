import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        jsMain {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                implementation(project(":compose-html-common"))

                implementation(npm("@material/web", DependencyVersions.materialWeb))
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose HTML Material 3",
        "Material 3 components for Compose HTML"
    ) {
        `Shreck Ye`()
    }
}
