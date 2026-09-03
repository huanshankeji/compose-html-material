import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

plugins {
    id("lib-conventions-without-publishing")
    id("com.huanshankeji.team.gitversioning.opensourceconvention.githubpackages.publish")
    id("com.huanshankeji.team.dokka.github-dokka-convention")
}

gitVersioningOpenSourceConventionGithubPackagesPublish {
    signAllPublicationsIfRelease(isRelease)
}

kotlin {
    js {
        // not needed with ES2015 from `com.huanshankeji.kotlin-multiplatform-js-browser-conventions`
        //useEsModules()
    }

    @OptIn(ExperimentalAbiValidation::class)
    abiValidation()
}
