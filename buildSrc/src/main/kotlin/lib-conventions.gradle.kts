import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

plugins {
    id("lib-conventions-without-publishing")
    id("com.huanshankeji.team.with-group")
    id("com.huanshankeji.team.gitversioning.opensourceconvention.githubpackages.publish")
    id("com.huanshankeji.team.dokka.github-dokka-convention")
}

gitVersioningOpenSourceConventionGithubPackagesPublish {
    signAllPublicationsIfRelease(isRelease)
}

kotlin {
    js {
        // not needed with `target.set("es2015")` below
        //useEsModules()

        compilerOptions {
            target.set("es2015")
        }
    }

    @OptIn(ExperimentalAbiValidation::class)
    abiValidation()
}
