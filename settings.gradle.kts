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

plugins {
    `gradle-enterprise`
}

include(
        ":dependencies",
        ":app"
)
