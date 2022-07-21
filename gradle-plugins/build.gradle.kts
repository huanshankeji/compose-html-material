import com.huanshankeji.SourceFile
import com.huanshankeji.generateKotlinSources

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.0.0-rc-2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin", "1.6.10"))
}


generateKotlinSources(
    sourceFiles = listOf(
        SourceFile(
            "GeneratedVersions.kt",
            "const val projectVersion = \"$projectVersion\"\n"
        )
    )
)


group = "com.huanshankeji"
version = projectVersion

gradlePlugin {
    plugins {
        getByName("com.huanshankeji.compose-web-material-conventions") {
            displayName = "Compose for Web Material conventions"
            description =
                "This plugin adds the needed Maven dependencies and npm devDependencies (mainly for Webpack) for a Compose for Web project with Material components."
        }
    }
}

pluginBundle {
    website = "https://github.com/huanshankeji/compose-web-material"
    vcsUrl = "$website.git"
    tags = listOf("kotlin", "compose", "web")
}
