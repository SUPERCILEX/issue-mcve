import com.github.triplet.gradle.androidpublisher.ResolutionStrategy
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")

    id("kotlin-android")
    id("kotlin-android-extensions")

    id("androidx.navigation.safeargs.kotlin")

    id("com.github.triplet.play")
    id("com.supercilex.gradle.versions")
}

android {
    compileSdkVersion(Config.SdkVersions.compile)

    defaultConfig {
        applicationId = "com.supercilex.test"
        minSdkVersion(Config.SdkVersions.min)
        targetSdkVersion(Config.SdkVersions.target)
        versionCode = 1 // Updated on every build
        versionName = "1.0.0"

        base.archivesBaseName = "issue-mcve"
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

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

play {
    serviceAccountCredentials.set(file("google-play-auto-publisher.json"))
    promoteTrack.set("alpha")
    resolutionStrategy.set(ResolutionStrategy.AUTO)
    defaultToAppBundles.set(true)
}

versionMaster {
    configureVersionCode.set(false)
}

dependencies {
    implementation(Config.Libs.Kotlin.jvm)
    implementation(Config.Libs.Kotlin.coroutines)
    implementation(Config.Libs.Kotlin.coroutinesTasks)

    implementation(Config.Libs.Jetpack.multidex)
    implementation(Config.Libs.Jetpack.appCompat)
    implementation(Config.Libs.Jetpack.constraint)
    implementation(Config.Libs.Jetpack.navFragments)
    implementation(Config.Libs.Jetpack.navUi)

    implementation(Config.Libs.Firebase.core)
}

apply(plugin = "com.google.gms.google-services")
