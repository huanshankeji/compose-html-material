/*
 * Shared early classpath bootstrap for settings (pluginManagement) and buildSrc:
 * versions and repositories needed before project conventions are on the classpath.
 */

// Currently wires GitHub Packages / mavenLocal for gradle-common *-dev-commit-* artifacts. gradle-common APIs are not on the classpath yet.
extra["repositories"] = fun RepositoryHandler.() {
    gradlePluginPortal()
    /*
    Adapted (simplified) from:
    https://github.com/huanshankeji/gradle-common/blob/main/kotlin-common/gradle-library/src/main/kotlin/com/huanshankeji/gitversioning/opensourceconvention/Repository.kt
    */
    exclusiveContent {
        forRepository {
            mavenLocal()
        }
        forRepository {
            /*
            Adapted from:
            https://github.com/huanshankeji/gradle-common/blob/main/kotlin-common/gradle-library/src/main/kotlin/com/huanshankeji/github/packages/maven/GithubPackagesMavenRegistry.kt
            */
            maven {
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
            includeVersionByRegex("""com\.huanshankeji(\..+)?""", ".*", """.*-dev-commit-[0-9a-f]+.*""")
        }
    }
}

extra["gradleCommonPluginsVersion"] = "0.12.0-dev-commit-b51d5c4fbf95e61c55f6eae488608af17781ab5e"

