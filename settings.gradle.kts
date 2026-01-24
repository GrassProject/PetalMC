import java.util.Locale

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.fabricmc.net/") {
            name = "Fabric"
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

if (!file(".git").exists()) {
    // Leaf start - project setup
    val errorText = """
        
        =====================[ ERROR ]=====================
         The Petal project directory is not a properly cloned Git repository.
         
         In order to build Leaf from source you must clone
         the Leaf repository using Git, not download a code
         zip from GitHub.
         
         See https://github.com/PaperMC/Paper/blob/main/CONTRIBUTING.md
         for further information on building and modifying Paper forks.
        ===================================================
    """.trimIndent()
    // Leaf end - project setup
    error(errorText)
}

rootProject.name = "petalmc"

for (name in listOf("petal-api", "petal-server")) {
    val projName = name.lowercase(Locale.ENGLISH)
    include(projName)
}
include("petal-fabric")