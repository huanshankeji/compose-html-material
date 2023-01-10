rootProject.name = "compose-web-material"

include("compose-web-common")
include(rootProject.name)
include("gradle-plugins")
project(":gradle-plugins").name = rootProject.name + "-gradle-plugins"
