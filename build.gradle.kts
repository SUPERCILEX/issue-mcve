buildscript {
    repositories {
        mavenLocal()
        google()
        jcenter()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    dependencies {
        classpath(Config.Plugins.android)
        classpath(Config.Plugins.kotlin)
        classpath(Config.Plugins.navArgs)
        classpath(Config.Plugins.google)
        classpath(Config.Plugins.publishing)
        classpath(Config.Plugins.versioning)
    }
}

plugins {
    `lifecycle-base`
    id("com.github.ben-manes.versions") version "0.28.0"
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
