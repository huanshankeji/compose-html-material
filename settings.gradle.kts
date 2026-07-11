pluginManagement {
    repositories {
        gradlePluginPortal()
        exclusiveContent {
            forRepository {
                mavenLocal()
            }
            forRepository {
                maven {
                    // Resolves the gradle-common settings plugin when it is not in mavenLocal().
                    // Mirrors gradle-common credential resolution; its APIs cannot be called from settings.gradle.kts:
                    // https://github.com/huanshankeji/gradle-common/blob/main/kotlin-common/gradle-library/src/main/kotlin/com/huanshankeji/github/packages/maven/GithubPackagesMavenRegistry.kt
                    url = uri("https://maven.pkg.github.com/huanshankeji/gradle-common")
                    credentials {
                        with(providers) {
                            username = gradleProperty("gpr.user").orElse(gradleProperty("gprUser")).getOrNull()
                            password = gradleProperty("gpr.key").orElse(gradleProperty("gprKey")).getOrNull()
                        }
                    }
                }
            }
            filter {
                includeVersionByRegex("com\\.huanshankeji", ".*", ".*-dev-commit-[0-9a-f]+.*")
            }
        }
    }
}

plugins {
    val gradleCommonPluginsVersion = "0.12.0-dev-commit-ac3e42c6941a896568c6eab78cfbb9c9f0ce50bf"
    id("com.huanshankeji.base-settings-conventions") version gradleCommonPluginsVersion
    id("com.huanshankeji.team.gitversioning.public-open-source-dependency-repositories") version gradleCommonPluginsVersion
}

publicOpenSourceDependencyRepositories {
    mavenCentralExcludingHuanshankeji()
}

rootProject.name = "compose-html-material"

include("compose-html-common")
include("compose-html-material-legacy")
include("compose-html-material3")
include("compose-html-material3-maicol07-material-web-additions")
include("gradle-plugins")
project(":gradle-plugins").name = "compose-html-material-gradle-plugins-legacy"
