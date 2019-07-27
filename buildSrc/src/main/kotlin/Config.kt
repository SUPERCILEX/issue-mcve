@Suppress("MayBeConstant")
object Config {
    private const val kotlinVersion = "1.3.41"

    object SdkVersions {
        val compile = 29
        val target = 29
        val min = 16
    }

    object Plugins {
        val android = "com.android.tools.build:gradle:3.6.0-alpha05"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val google = "com.google.gms:google-services:4.3.0"
        val publishing = "com.github.triplet.gradle:play-publisher:2.4.0-SNAPSHOT"
    }

    object Libs {
        object Kotlin {
            private val coroutinesVersion = "1.2.1"

            val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"

            val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
            val coroutinesTasks =
                    "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion"
        }

        object Jetpack {
            val multidex = "androidx.multidex:multidex:2.0.1"
            val design = "androidx.appcompat:appcompat:1.1.0-rc01"
            val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        }

        object Firebase {
            val core = "com.google.firebase:firebase-analytics:17.0.1"
        }

        object Anko {
            private const val version = "0.10.8"

            val appCompat = "org.jetbrains.anko:anko-appcompat-v7-commons:$version"
            val design = "org.jetbrains.anko:anko-design:$version"
        }
    }
}
