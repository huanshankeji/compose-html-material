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


val generateVersion = "generateVersion"
val generatedSourcesDir = buildDir.resolve("gen/main/kotlin")

tasks.register(generateVersion) {
    generatedSourcesDir.mkdirs()
    val generatedVersionsSourceFile = generatedSourcesDir.resolve("GeneratedVersions.kt")
    generatedVersionsSourceFile.writeText("const val projectVersion = \"$projectVersion\"\n")
}

tasks.compileKotlin {
    dependsOn(generateVersion)
}

kotlin.sourceSets["main"].kotlin.srcDir(generatedSourcesDir)


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
