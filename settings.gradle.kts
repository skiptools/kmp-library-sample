dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        mavenLocal()
    }
    //versionCatalogs {
        //create("libs") {
            //from(files("gradle/libs.versions.toml"))
        //}
    //}
}

include(":mpp-library")
