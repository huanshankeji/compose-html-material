import com.huanshankeji.team.ShreckYe
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    js {
        useEsModules()
    }

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
        "Material 3 components for Compose HTML",
        "2024"
    ) {
        ShreckYe()
    }
}
