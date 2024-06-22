import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("maven-publish")
}

kotlin {
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
                //export(moko.resources)
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //api(moko.resources)
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

dependencies {
    //commonMainApi(moko.resources)
}

//multiplatformResources {
//    resourcesPackage.set("com.icerockdev.library")
//    configureCopyXCFrameworkResources("MultiPlatformLibrary")
//}

//publishing {
//    repositories {
//        maven {
//
//        }
//    }
//    publications {
//        gpr(MavenPublication) {
//            from(components.java)
//        }
//    }
//}
