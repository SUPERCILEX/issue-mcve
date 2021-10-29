plugins {
    `lifecycle-base`
    alias(libs.plugins.depUpdates)

    kotlin("jvm") version libs.versions.kotlin.get() apply false
    alias(libs.plugins.agp) apply false
    alias(libs.plugins.navigation) apply false
    alias(libs.plugins.googleServices) apply false
    alias(libs.plugins.gpp) apply false
    alias(libs.plugins.versionOrchestrator) apply false
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"

    publishAlways()
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}
