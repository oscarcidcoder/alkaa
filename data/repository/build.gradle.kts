plugins {
    id(GradlePlugin.KOTLIN_LIBRARY)
}

dependencies {
    implementation(projects.domain)

    implementation(libs.koin.core)
    implementation(libs.coroutines.core)
}
