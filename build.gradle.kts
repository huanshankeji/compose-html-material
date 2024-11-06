tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

plugins {
    id("org.jetbrains.dokka")
}

dependencies {
    listOf(
        "compose-html-common",
        "compose-html-material3"
    ).forEach {
        dokka(project(":$it"))
    }
}
