package gradle

import extensions.addDefaultConfig

plugins {
    id("com.android.dynamic-feature")
    id("kotlin-android")
    id("gradle.quality")
}

android {
    addDefaultConfig()
}

fun libs(lib: String) =
    project.extensions.getByType<VersionCatalogsExtension>()
        .named("libs").findDependency(lib)
        .get()

dependencies {
    implementation(libs("logcat"))
    implementation(project(":app"))
    androidTestImplementation(project(":app"))

    implementation(libs("androidx.playcore"))
}
