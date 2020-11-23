plugins {
    `java-platform`
}

dependencies.constraints {
    val coroutinesVersion = "1.4.1"
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$coroutinesVersion")

    val navVersion = "2.3.1"
    api("androidx.multidex:multidex:2.0.1")
    api("androidx.appcompat:appcompat:1.3.0-alpha02")
    api("androidx.constraintlayout:constraintlayout:2.1.0-alpha1")
    api("androidx.navigation:navigation-fragment-ktx:$navVersion")
    api("androidx.navigation:navigation-ui-ktx:$navVersion")

    api("com.google.firebase:firebase-analytics:18.0.0")
}
