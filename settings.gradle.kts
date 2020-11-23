pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
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
