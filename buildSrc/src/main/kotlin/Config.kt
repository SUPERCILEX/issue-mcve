@Suppress("MayBeConstant")
object Config {
    private const val kotlinVersion = "1.3.11"

    object SdkVersions {
        val compile = 28
        val target = 28
        val min = 16
    }

    object Plugins {
        val android = "com.android.tools.build:gradle:3.4.0-alpha10"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val google = "com.google.gms:google-services:4.2.0"
        val publishing = "com.github.triplet.gradle:play-publisher:2.0.0"
    }

    object Libs {
        object Kotlin {
            val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
        }

        object Anko {
            private const val version = "0.10.8"

            val appCompat = "org.jetbrains.anko:anko-appcompat-v7-commons:$version"
            val design = "org.jetbrains.anko:anko-design:$version"
        }

        object Support {
            val multidex = "com.android.support:multidex:1.0.3"
            val design = "com.android.support:design:28.0.0"
            val constraint = "com.android.support.constraint:constraint-layout:1.1.3"
        }
    }
}
