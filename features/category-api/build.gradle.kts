plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.PARCELIZE)
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.koin.android)
}
