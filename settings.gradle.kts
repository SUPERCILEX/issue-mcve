pluginManagement {
    repositories {
        mavenLocal()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.namespace) {
                "com.android" ->
                    useModule("com.android.tools.build:gradle:${requested.version}")
                "androidx.navigation.safeargs" ->
                    useModule("androidx.navigation:navigation-safe-args-gradle-plugin:${requested.version}")
                "com.google.gms" ->
                    useModule("com.google.gms:google-services:${requested.version}")
                "com.github.triplet" ->
                    useModule("com.github.triplet.gradle:play-publisher:${requested.version}")
                "com.supercilex.gradle" ->
                    useModule("com.supercilex.gradle:version-orchestrator:${requested.version}")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        google().content {
            includeGroup("com.android")
            includeGroupByRegex("com\\.android\\..*")
            includeGroupByRegex("com\\.google\\..*")
            includeGroupByRegex("androidx\\..*")
        }

        mavenCentral()
    }

    enableFeaturePreview("VERSION_CATALOGS")
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.5.20")
            version("agp", "7.0.3")
            version("googleServices", "4.3.10")
            version("gpp", "3.7.0-SNAPSHOT")
            version("versionOrchestrator", "0.9.0")
            version("depUpdates", "0.39.0")

            alias("agp").toPluginId("com.android.application").versionRef("agp")
            alias("googleServices")
                    .toPluginId("com.google.gms.google-services")
                    .versionRef("googleServices")
            alias("gpp").toPluginId("com.github.triplet.play").versionRef("gpp")
            alias("versionOrchestrator")
                    .toPluginId("com.supercilex.gradle.versions")
                    .versionRef("versionOrchestrator")
            alias("depUpdates")
                    .toPluginId("com.github.ben-manes.versions")
                    .versionRef("depUpdates")
            alias("navigation")
                    .toPluginId("androidx.navigation.safeargs.kotlin")
                    .versionRef("navigation")

            version("coroutines", "1.5.2")
            version("navigation", "2.4.0-beta01")
            version("multidex", "2.0.1")
            version("appcompat", "1.4.0-rc01")
            version("constraintlayout", "2.1.1")
            version("recyclerview", "1.3.0-alpha01")
            version("firebase", "19.0.2")

            alias("coroutines-android")
                    .to("org.jetbrains.kotlinx", "kotlinx-coroutines-android")
                    .versionRef("coroutines")
            alias("coroutines-playServices")
                    .to("org.jetbrains.kotlinx", "kotlinx-coroutines-play-services")
                    .versionRef("coroutines")
            alias("multidex").to("androidx.multidex", "multidex").versionRef("multidex")
            alias("appcompat").to("androidx.appcompat", "appcompat").versionRef("appcompat")
            alias("constraintlayout")
                    .to("androidx.constraintlayout", "constraintlayout")
                    .versionRef("constraintlayout")
            alias("recyclerview")
                    .to("androidx.recyclerview", "recyclerview")
                    .versionRef("recyclerview")
            alias("navigation-fragment")
                    .to("androidx.navigation", "navigation-fragment-ktx")
                    .versionRef("navigation")
            alias("navigation-ui")
                    .to("androidx.navigation", "navigation-ui-ktx")
                    .versionRef("navigation")
            alias("firebase-analytics")
                    .to("com.google.firebase", "firebase-analytics")
                    .versionRef("firebase")
        }
    }
}

plugins {
    `gradle-enterprise`
}

include(
        ":app"
)
