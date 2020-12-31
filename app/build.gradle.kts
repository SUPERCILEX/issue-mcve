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
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.supercilex.test"
        minSdkVersion(16)
        targetSdkVersion(30)
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

versionOrchestrator {
    configureVersionCode.set(false)
}

dependencies {
    api(platform(project(":dependencies")))

    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services")

    implementation("androidx.multidex:multidex")
    implementation("androidx.appcompat:appcompat")
    implementation("androidx.constraintlayout:constraintlayout")
    implementation("androidx.recyclerview:recyclerview")
    implementation("androidx.navigation:navigation-fragment-ktx")
    implementation("androidx.navigation:navigation-ui-ktx")

    implementation("com.google.firebase:firebase-analytics")
}

apply(plugin = "com.google.gms.google-services")
