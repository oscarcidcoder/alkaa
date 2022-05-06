package gradle

import extensions.addComposeConfig
import extensions.addComposeDependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
}

fun libs(lib: String) =
    project.extensions.getByType<VersionCatalogsExtension>()
        .named("libs").findDependency(lib)
        .get()

android {
    addComposeConfig()
}

dependencies {
    implementation(libs("compose"))
}
