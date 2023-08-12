pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Note Taking App"
include(":app")
include(":feature:authentication:data")
include(":feature:authentication:domain")
include(":feature:authentication:ui")
include(":core:network")
include(":core:common")
include(":core:feature_api")
