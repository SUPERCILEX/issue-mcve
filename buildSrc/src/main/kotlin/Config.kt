@Suppress("MayBeConstant")
object Config {
    private const val kotlinVersion = "1.3.21"

    object SdkVersions {
        val compile = 28
        val target = 28
        val min = 16
    }

    object Plugins {
        val android = "com.android.tools.build:gradle:3.5.0-alpha06"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val google = "com.google.gms:google-services:4.2.0"
        val publishing = "com.github.triplet.gradle:play-publisher:2.1.1"
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
            val multidex = "androidx.multidex:multidex:2.0.1"
            val design = "androidx.appcompat:appcompat:1.0.2"
            val constraint = "androidx.constraintlayout:constraintlayout:1.1.3"
        }
    }
}
