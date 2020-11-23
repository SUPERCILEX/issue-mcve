plugins {
    `java-platform`
}

dependencies.constraints {
    val coroutinesVersion = "1.3.7"
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion")

    val navVersion = "2.3.0-rc01"
    api("androidx.multidex:multidex:2.0.1")
    api("androidx.appcompat:appcompat:1.2.0-rc01")
    api("androidx.constraintlayout:constraintlayout:2.0.0-beta7")
    api("androidx.navigation:navigation-fragment-ktx:$navVersion")
    api("androidx.navigation:navigation-ui-ktx:$navVersion")

    api("com.google.firebase:firebase-analytics:17.4.3")
}
