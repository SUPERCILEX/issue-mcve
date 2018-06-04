object Config {
    private const val kotlinVersion = "1.2.41"

    object SdkVersions {
        const val compile = 27
        const val target = 27
        const val min = 16
    }

    object Plugins {
        const val android = "com.android.tools.build:gradle:3.2.0-alpha16"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        const val google = "com.google.gms:google-services:4.0.1"
        const val publishing = "com.github.Triple-T:gradle-play-publisher:2aa244d7d2"
    }

    object Libs {
        object Kotlin {
            const val jvm = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
        }

        object Anko {
            private const val version = "0.10.5"

            const val appCompat = "org.jetbrains.anko:anko-appcompat-v7-commons:$version"
            const val design = "org.jetbrains.anko:anko-design:$version"
        }

        object Support {
            const val multidex = "com.android.support:multidex:1.0.3"
            const val design = "com.android.support:design:27.1.1"
            const val constraint = "com.android.support.constraint:constraint-layout:1.1.0"
        }
    }
}
