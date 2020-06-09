object Config {
    private const val kotlinVersion = "1.3.72"
    private const val navVersion = "2.3.0-rc01"

    object SdkVersions {
        const val compile = 29
        const val target = 29
        const val min = 16
    }

    object Plugins {
        const val android = "com.android.tools.build:gradle:4.2.0-alpha01"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val navArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion"
        const val google = "com.google.gms:google-services:4.3.3"
        const val publishing = "com.github.triplet.gradle:play-publisher:3.0.0-SNAPSHOT"
        const val versioning = "com.supercilex.gradle:version-master:1.0.0-SNAPSHOT"
    }

    object Libs {
        object Kotlin {
            private const val coroutinesVersion = "1.3.7"

            const val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

            const val coroutines =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
            const val coroutinesTasks =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
        }

        object Jetpack {
            const val multidex = "androidx.multidex:multidex:2.0.1"
            const val appCompat = "androidx.appcompat:appcompat:1.2.0-rc01"
            const val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta7"
            const val navFragments = "androidx.navigation:navigation-fragment-ktx:$navVersion"
            const val navUi = "androidx.navigation:navigation-ui-ktx:$navVersion"
        }

        object Firebase {
            const val core = "com.google.firebase:firebase-analytics:17.4.3"
        }
    }
}
