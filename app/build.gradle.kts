import com.github.triplet.gradle.androidpublisher.ResolutionStrategy
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")

    id("kotlin-android")
    id("kotlin-parcelize")

    id("androidx.navigation.safeargs.kotlin")

    id("com.github.triplet.play")
    id("com.supercilex.gradle.versions")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.supercilex.test"
        minSdk = 16
        targetSdk = 31
        versionCode = 1 // Updated on every build
        versionName = "1.0.0"

        base.archivesName.set("issue-mcve")
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

versionOrchestrator {
    configureVersionCode.set(false)
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(libs.coroutines.android)
    implementation(libs.coroutines.playServices)

    implementation(libs.multidex)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.recyclerview)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(libs.firebase.analytics)
}

apply(plugin = "com.google.gms.google-services")
