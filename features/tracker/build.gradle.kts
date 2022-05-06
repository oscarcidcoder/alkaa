import extensions.addComposeConfig
import extensions.addComposeDependencies
import extensions.addDefaultConfig

plugins {
    id(GradlePlugin.DYNAMIC_FEATURE)
}

android {
    addDefaultConfig()
    addComposeConfig()
}

dependencies {
    implementation(projects.domain)
    implementation(projects.libraries.designsystem)

    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.coroutines.core)
    implementation(libs.compose.activity)

    addComposeDependencies()

    testImplementation(projects.libraries.test)
}
