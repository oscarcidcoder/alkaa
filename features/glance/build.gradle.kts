plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE)
}

dependencies {
    implementation(projects.domain)
    implementation(projects.libraries.navigation)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.androidx.glance)
}
