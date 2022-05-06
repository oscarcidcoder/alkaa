plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE)
}

dependencies {
    implementation(libs.koin.android)
    implementation(libs.compose.viewmodel)
}
