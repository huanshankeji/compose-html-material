import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.*

plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    id("org.jetbrains.compose")
    id("com.huanshankeji.kotlin-multiplatform-sonatype-ossrh-publish-conventions")
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

group = "com.huanshankeji"
version = projectVersion
