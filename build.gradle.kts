plugins {
    `lifecycle-base`
    id("com.github.ben-manes.versions") version "0.28.0"

    kotlin("jvm") version "1.4.20" apply false
    id("com.android.application") version "4.1.0" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.3.1" apply false
    id("com.google.gms.google-services") version("4.3.3") apply false
    id("com.github.triplet.play") version "3.0.0" apply false
    id("com.supercilex.gradle.versions") version "0.7.0" apply false
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
