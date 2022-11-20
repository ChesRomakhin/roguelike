rootProject.name = "rougelike"
include(":vm")
project(":vm").projectDir = file("./vm")

include(":world")
project(":world").projectDir = file("./world")