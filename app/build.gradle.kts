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
        unitTests.isReturnDefaultValues = true
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

    implementation(libs.logcat)
    implementation(libs.compose.navigation)
    implementation(libs.compose.activity)
    implementation(libs.accompanist.animation)
    implementation(libs.androidx.playcore)
    implementation(libs.koin.android)

    addComposeDependencies()
}
