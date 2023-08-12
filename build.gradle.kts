// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.3")
        classpath("com.google.gms:google-services:4.3.15")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
    }
}
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.android.library") version "8.1.0" apply false
}