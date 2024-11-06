import org.jetbrains.dokka.gradle.tasks.DokkaGeneratePublicationTask

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

val dokkaGeneratePublicationHtml by tasks.getting(DokkaGeneratePublicationTask::class)
tasks.register<Sync>("generateSite") {
    group = "site"

    val destRootDir = layout.buildDirectory.dir("site")
    into(destRootDir)
    from(dokkaGeneratePublicationHtml) {
        into("api-documentation")
    }
    from(layout.projectDirectory.dir("site"))
}
