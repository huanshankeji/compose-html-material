val composeWebMaterial = "compose-web-material"
rootProject.name = composeWebMaterial

include("compose-web-common")

include("$composeWebMaterial:common")
include("$composeWebMaterial:mwc")
include("$composeWebMaterial:mdc")
include("$composeWebMaterial:mdc:gradle-plugins")
include("$composeWebMaterial:all")


fun ProjectDescriptor.setProjectConcatenatedNames(prefix: String) {
    name = prefix + name
    for (child in children)
        child.setProjectConcatenatedNames("$name-")
}
rootProject.children.forEach { it.setProjectConcatenatedNames("") }
