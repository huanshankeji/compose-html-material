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
                // TODO: consider extracting common code (SlotScope, ISlot, ExperimentalComposeHtmlMaterialApi) into
                //  a separate `compose-html-material3-common` module to avoid depending on the full material3 module.
                implementation(project(":compose-html-material3"))

                implementation(npm("@maicol07/material-web-additions", DependencyVersions.materialWebAdditions))
            }
        }
    }

    compilerOptions {
        optIn.add("com.huanshankeji.compose.html.material3.ExperimentalComposeHtmlMaterialApi")
        optIn.add("com.huanshankeji.compose.html.material3.maicol07.materialwebadditions.MaterialWebAdditionsApi")
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose HTML Material 3 - additional components based on maicol07's Material Web Additions",
        "Material Web Additions components for Compose HTML based on [maicol07's Material Web Additions](https://github.com/maicol07/material-web-additions)",
        "2026"
    ) {
        ShreckYe()
    }
}
