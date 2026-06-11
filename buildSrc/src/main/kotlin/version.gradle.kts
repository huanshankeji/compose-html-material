// extracted into a separate script so the version can be set before `dokka-convention`

plugins {
    id("com.huanshankeji.git-version")
}

gitVersion {
    baseVersion.set(projectBaseVersion)
}
