import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget()

    val iosArm64 = iosArm64()
    val iosX64 = iosX64()
    val iosSimulatorArm64 = iosSimulatorArm64()
    val macosArm64 = macosArm64()
    val macosX64 = macosX64()

    val xcFramework = XCFramework("MultiPlatformLibrary")
    configure(listOf(iosArm64, iosX64, iosSimulatorArm64, macosArm64, macosX64)) {
        binaries {
            framework {
                isStatic = true
                baseName = "MultiPlatformLibrary"
                xcFramework.add(this)
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinxCoroutines)
                //implementation(libs.ktor.client.core)
                //implementation(libs.ktor.client.cio)
                //implementation(libs.ktor.client.content.negotiation)
            }
        }
        val iosMain by creating {
            dependsOn(commonMain)
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val macosArm64Main by getting {
            dependsOn(iosMain)
        }
        val macosX64Main by getting {
            dependsOn(iosMain)
        }
    }
}

android {
    namespace = "com.example.library"
    compileSdk = libs.versions.compileSdk.get().toInt()
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xmlX")
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jvm.get())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jvm.get())
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions {
        jvmTarget = libs.versions.jvm.get().toString()
    }
}

