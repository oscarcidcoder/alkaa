plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE)
    id(GradlePlugin.PARCELIZE)
}

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.features.categoryApi)
    implementation(projects.domain)
    implementation(projects.libraries.designsystem)

    testImplementation(projects.libraries.test)
    androidTestImplementation(projects.libraries.test)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)
}
