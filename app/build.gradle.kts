import com.android.build.gradle.internal.dsl.ManagedVirtualDevice
import extensions.addComposeConfig
import extensions.addComposeDependencies

plugins {
    id(GradlePlugin.ANDROID_APPLICATION)
    id(GradlePlugin.KOTLIN_ANDROID)
    id(GradlePlugin.KOTLIN_QUALITY)
    id(GradlePlugin.PARCELIZE)
}

android {
    defaultConfig {
        applicationId = "com.escodro.alkaa"
        versionCode = Releases.versionCode
        versionName = Releases.versionName

        compileSdk = Versions.compileSdk
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        setProperty("archivesBaseName", "${parent?.name?.capitalize()}-$versionName")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-android.txt", "proguard-rules.pro")
        }
    }

    lint {
        warningsAsErrors = true
        abortOnError = true
        htmlReport = true
        checkDependencies = true

        lintConfig = file("${rootDir}/config/filters/lint.xml")
        htmlOutput = file("${buildDir}/reports/lint.html")
    }

    setDynamicFeatures(setOf(":features:tracker"))

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    addComposeConfig()

    testOptions {
        managedDevices {
            devices {
                add(
                    ManagedVirtualDevice("pixel4api31").apply {
                        device = "Pixel 4"
                        apiLevel = 31
                        systemImageSource = "aosp"
                        require64Bit = true
                    }
                )
                add(
                    ManagedVirtualDevice("pixel2api28").apply {
                        device = "Pixel 2"
                        apiLevel = 28
                        systemImageSource = "aosp"
                        require64Bit = true
                    }
                )
            }
            groups {
                create("alkaaDevices").apply {
                    targetDevices.addAll(
                        listOf(
                            devices.getByName("pixel4api31"),
                            // re-add it later devices.getByName("pixel2api28"),
                        )
                    )
                }
                unitTests.isReturnDefaultValues = true
            }
        }
    }

dependencies {
    implementation(projects.libraries.core)
    implementation(projects.libraries.splitInstall)
    implementation(projects.libraries.designsystem)
    implementation(projects.libraries.navigation)
    implementation(projects.data.local)
    implementation(projects.data.datastore)
    implementation(projects.data.repository)
    implementation(projects.domain)
    implementation(projects.features.task)
    implementation(projects.features.alarm)
    implementation(projects.features.categoryApi)
    implementation(projects.features.category)
    implementation(projects.features.preference)
    implementation(projects.features.search)
    implementation(projects.features.glance)

    implementation(Deps.logcat)
    implementation(Deps.compose.navigation)
    implementation(Deps.compose.activity)
    implementation(Deps.accompanist.animation)
    implementation(Deps.android.playCore)
    implementation(Deps.koin.android)

        androidTestImplementation(projects.libraries.test)
        androidTestImplementation(Deps.koin.test)

        addComposeDependencies()
    }
}
