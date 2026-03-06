import com.huanshankeji.team.ShreckYe
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
                implementation(project(":compose-html-material3"))

                implementation(npm("@maicol07/material-web-additions", DependencyVersions.materialWebAdditions))
            }
        }
    }

    compilerOptions {
        optIn.add("com.huanshankeji.compose.html.material3.ExperimentalComposeHtmlMaterialApi")
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose HTML Material 3 - maicol07 Material Web Additions",
        "Material Web Additions components for Compose HTML based on maicol07's material-web-additions library",
        "2025"
    ) {
        ShreckYe()
    }
}
