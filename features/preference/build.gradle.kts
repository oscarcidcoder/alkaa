plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
    id(GradlePlugin.COMPOSE)
}

dependencies {
    implementation(projects.domain)
    implementation(projects.libraries.core)
    implementation(projects.libraries.designsystem)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    testImplementation(projects.libraries.test)
    androidTestImplementation(projects.libraries.test)
}
