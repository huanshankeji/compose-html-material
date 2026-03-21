plugins {
    id("lib-conventions-without-publishing")
    id("com.huanshankeji.maven-central-publish-conventions")
    id("com.huanshankeji.team.dokka.github-dokka-convention")
}

kotlin {
    js {
        // not needed with `target.set("es2015")` below
        //useEsModules()

        compilerOptions {
            target.set("es2015")
        }
    }
}
