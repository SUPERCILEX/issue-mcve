plugins {
    `lifecycle-base`
    id("com.github.ben-manes.versions") version "0.36.0"

    kotlin("jvm") version "1.4.21" apply false
    id("com.android.application") version "7.0.0-alpha04" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.3.2" apply false
    id("com.google.gms.google-services") version "4.3.4" apply false
    id("com.github.triplet.play") version "3.2.0-agp4.2-2" apply false
    id("com.supercilex.gradle.versions") version "0.9.0" apply false
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"

    publishAlways()
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}
