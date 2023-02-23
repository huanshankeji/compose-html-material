import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        val jsMain by getting {
            dependencies {
                api(project(":compose-web-material:compose-web-material-mwc"))
                api(project(":compose-web-material:compose-web-material-mdc"))
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose for Web Material, all components",
        "Some Material components for Compose for Web, including both `mwc` and `mdc` components"
    ) {
        `Shreck Ye`()
    }
}
