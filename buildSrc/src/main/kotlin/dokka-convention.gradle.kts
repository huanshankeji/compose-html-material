plugins {
    id("org.jetbrains.dokka")
}

dokka {
    dokkaSourceSets.all {
        sourceLink {
            remoteUrl("https://github.com/huanshankeji/compose-html-material/tree/a1f4168de1bfbab045dbe95daf2d0bd7a59ea46b/${project.name}")
            remoteLineSuffix.set("#L")
        }
    }
}
