plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
}

dependencies {
    implementation(libs.androidx.corektx)
    implementation(libs.androidx.material)
    implementation(libs.coroutines.core)
    implementation(libs.koin.android)
}
