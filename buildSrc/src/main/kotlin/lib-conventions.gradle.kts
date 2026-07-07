import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

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

    @OptIn(ExperimentalAbiValidation::class)
    abiValidation()
}
