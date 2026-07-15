import org.gradle.api.artifacts.dsl.RepositoryHandler

plugins {
    `kotlin-dsl`
}

apply(from = "../gradle/classpath-bootstrap.gradle.kts")
@Suppress("UNCHECKED_CAST")
(extra["repositories"] as RepositoryHandler.() -> Unit)(repositories)

val gradleCommonPluginsVersion = extra["gradleCommonPluginsVersion"]

dependencies {
    implementation(kotlin("gradle-plugin", "2.4.0"))
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.4.0")
    implementation("org.jetbrains.compose:compose-gradle-plugin:1.10.3")
    implementation("com.huanshankeji:common-gradle-dependencies:0.10.0-20251024")
    implementation("com.huanshankeji.team:project-gradle-plugins:$gradleCommonPluginsVersion")
    implementation("com.huanshankeji:kotlin-common-project-gradle-plugins:$gradleCommonPluginsVersion")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:2.2.0")
}

/*
kotlin {
    compilerOptions {
        optIn.addAll(
            "com.huanshankeji.GradleCommonExperimentalApi",
        )
        //freeCompilerArgs.add("-Xcontext-parameters")
    }
}
*/
