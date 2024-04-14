import com.huanshankeji.SourceFile
import com.huanshankeji.generateKotlinSources

plugins {
    `kotlin-dsl`
    id("com.gradle.plugin-publish") version "1.2.1"
}

kotlin.jvmToolchain(8)

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
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
    website.set("https://github.com/huanshankeji/compose-html-material")
    vcsUrl.set("${website.get()}.git")

    plugins {
        getByName("com.huanshankeji.compose-html-material-conventions") {
            displayName = "Compose HTML Material conventions"
            description =
                "This plugin adds the needed Maven dependencies and npm devDependencies (mainly for Webpack) for a Compose HTML project with Material components."
            tags.set(listOf("kotlin", "kotlin-js", "compose-multiplatform", "compose-html"))
        }
    }
}
