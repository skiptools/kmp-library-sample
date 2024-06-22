buildscript {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        mavenLocal()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
        classpath(libs.composeJetBrainsPlugin)
    }
}

plugins {
    alias(libs.plugins.androidLibrary) apply false
}
