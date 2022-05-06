plugins {
    id(GradlePlugin.KOTLIN_LIBRARY)
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.logging)
    implementation(libs.logback)
    implementation(libs.coroutines.core)

    testImplementation(libs.test.junit)
    testImplementation(libs.test.mockk)
    testImplementation(libs.coroutines.test)
}
