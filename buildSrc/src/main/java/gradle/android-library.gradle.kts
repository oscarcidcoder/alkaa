package gradle

import extensions.addDefaultConfig

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("gradle.quality")
}

fun libs(lib: String) =
    project.extensions.getByType<VersionCatalogsExtension>()
        .named("libs").findDependency(lib)
        .get()



android {
    addDefaultConfig()

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
            consumerProguardFiles("proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs("logcat"))
}
