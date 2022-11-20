import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.*

plugins {
    id("com.huanshankeji.kotlin-multiplatform-js-browser-conventions")
    id("org.jetbrains.compose")
    id("com.huanshankeji.sonatype-ossrh-publish")
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

group = "com.huanshankeji"
version = projectVersion

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing.publications.withType<MavenPublication> {
    artifact(javadocJar)
}
