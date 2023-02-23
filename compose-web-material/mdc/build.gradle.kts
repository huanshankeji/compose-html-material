import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        val jsMain by getting {
            dependencies {
                api(project(":compose-web-material:compose-web-material-common"))

                implementation(npm("@material/card", DependencyVersions.mdc))
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Compose for Web Material, mdc",
        "Some component wrappers of Material Components for the web (`mdc`) components for Compose for Web"
    ) {
        `Shreck Ye`()
    }
}
