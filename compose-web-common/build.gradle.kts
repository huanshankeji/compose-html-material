import com.huanshankeji.team.`Shreck Ye`
import com.huanshankeji.team.pomForTeamDefaultOpenSource

plugins {
    `lib-conventions`
}

publishing.publications.withType<MavenPublication> {
    pomForTeamDefaultOpenSource(
        project,
        "Huanshankeji Compose for Web common",
        "Huanshankeji's common code for Compose for Web"
    ) {
        `Shreck Ye`()
    }
}
