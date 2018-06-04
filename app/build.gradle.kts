import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("com.github.triplet.play")
}

android {
    compileSdkVersion(Config.SdkVersions.compile)

    defaultConfig {
        applicationId = "com.supercilex.test"
        minSdkVersion(Config.SdkVersions.min)
        targetSdkVersion(Config.SdkVersions.target)
        versionCode = 3
        versionName = "1.0"
        multiDexEnabled = true
    }

    signingConfigs {
        create("release") {
            val keystorePropertiesFile = file("keystore.properties")
            val keystoreProperties = Properties()
            keystoreProperties.load(FileInputStream(keystorePropertiesFile))

            keyAlias = keystoreProperties["keyAlias"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
        }
    }

    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"))
        }
    }

    lintOptions {
        isAbortOnError = false
    }

    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

androidExtensions {
    isExperimental = true
}

play {
    track = "internal"
    resolutionStrategy = "auto"
    jsonFile = file("google-play-auto-publisher.json")
}

dependencies {
    implementation(Config.Libs.Kotlin.jvm)
    implementation(Config.Libs.Support.multidex)
    implementation(Config.Libs.Support.design)
    implementation(Config.Libs.Support.constraint)
    implementation(Config.Libs.Anko.design)
    implementation(Config.Libs.Anko.appCompat)
}

apply(plugin = "com.google.gms.google-services")
