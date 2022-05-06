plugins {
    id(GradlePlugin.ANDROID_LIBRARY)
}

dependencies{
    implementation(projects.data.repository)

    implementation(libs.koin.android)
    implementation(libs.androidx.datastore)
}
