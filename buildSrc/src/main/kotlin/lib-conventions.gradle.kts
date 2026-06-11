plugins {
    id("common-conventions")
    id("lib-conventions-without-publishing")
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
