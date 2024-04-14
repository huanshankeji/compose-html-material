rootProject.name = "compose-html-material"

include("compose-html-common")
include("compose-html-material")
include("compose-html-material3")
include("gradle-plugins")
project(":gradle-plugins").name = rootProject.name + "-gradle-plugins"
