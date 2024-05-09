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
                api("com.varabyte.kobweb:compose-html-ext:${DependencyVersions.kobweb}")
                //implementation(commonDependencies.kotlinx.coroutines.core())
            }
        }
    }
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Huanshankeji Compose HTML common",
        "Huanshankeji's common code for Compose HTML"
    ) {
        `Shreck Ye`()
    }
}
