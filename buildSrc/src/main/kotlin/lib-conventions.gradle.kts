plugins {
    id("lib-conventions-without-publishing")
    id("com.huanshankeji.kotlin-multiplatform-sonatype-ossrh-publish-conventions")
    id("com.huanshankeji.team.dokka.github-dokka-convention")
}

// To reduce the bundle size, this is only needed in the app project.
// They might also be needed if the project is published to npm, but it's not now.
/*
kotlin {
    js {
        compilerOptions {
            target.set("es2015")
        }
        useEsModules()
    }
}
*/
