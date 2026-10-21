import com.huanshankeji.team.ShreckYe
import com.huanshankeji.team.setUpPomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

kotlin {
    sourceSets {
        getByName("jsMain") {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)
                api("com.varabyte.kobweb:compose-html-ext:${DependencyVersions.kobweb}")
                //implementation(commonDependencies.kotlinx.coroutines.core())
            }
        }
    }
}

mavenPublishing {
    pom {
        setUpPomForTeamDefaultOpenSource(
            project,
            "Huanshankeji Compose HTML common",
            "Huanshankeji's common code for Compose HTML",
            "2023"
        ) {
            ShreckYe()
        }
    }
}
