tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

plugins {
    id("org.jetbrains.dokka")
}

// workaround for https://github.com/Kotlin/dokka/issues/3903 from https://github.com/Kotlin/dokka/issues/2260 TODO remove when it's fixed
repositories {
    mavenCentral()
}

dependencies {
    listOf(
        "compose-html-common",
        "compose-html-material3"
    ).forEach {
        dokka(project(":$it"))
    }
}
