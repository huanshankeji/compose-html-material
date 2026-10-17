import org.jetbrains.dokka.gradle.tasks.DokkaGeneratePublicationTask

plugins {
    id("com.huanshankeji.root-project-conventions")
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

val dokkaGeneratePublicationHtml = tasks.named<DokkaGeneratePublicationTask>("dokkaGeneratePublicationHtml")
tasks.register<Sync>("generateSite") {
    group = "site"

    val destRootDir = layout.buildDirectory.dir("site")
    into(destRootDir)
    from(dokkaGeneratePublicationHtml) {
        into("api-documentation")
    }
    from(layout.projectDirectory.dir("site"))
}
