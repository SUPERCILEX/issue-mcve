@Suppress("MayBeConstant")
object Config {
    private const val kotlinVersion = "1.2.71"

    object SdkVersions {
        val compile = 28
        val target = 28
        val min = 16
    }

    object Plugins {
        val android = "com.android.tools.build:gradle:3.3.0-alpha13"
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        val google = "com.google.gms:google-services:4.1.0"
        val publishing = "com.github.Triple-T:gradle-play-publisher:50fa782396054a4b18faa208d607ba267c4f2e45"
    }

    object Libs {
        object Kotlin {
            val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
        }

        object Anko {
            private const val version = "0.10.7"

            val appCompat = "org.jetbrains.anko:anko-appcompat-v7-commons:$version"
            val design = "org.jetbrains.anko:anko-design:$version"
        }

        object Support {
            val multidex = "com.android.support:multidex:1.0.3"
            val design = "com.android.support:design:28.0.0-rc01"
            val constraint = "com.android.support.constraint:constraint-layout:1.1.2"
        }
    }
}
