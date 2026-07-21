plugins {
    id("com.huanshankeji.team.with-group")
    id("com.huanshankeji.team.gitversioning.opensourceconvention.githubpackages.publish")
    id("dokka-convention")
}

gitVersioningOpenSourceConventionGithubPackagesPublish {
    signAllPublicationsIfRelease(isRelease)
}
