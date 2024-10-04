plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.plumsoftware.pdf_doc_files"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.plumsoftware.pdf_doc_files"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    lint {
        checkTestSources = true
        ignoreTestSources = true
        checkGeneratedSources = true
        checkDependencies = true
        targetSdk = 34
        abortOnError = false

        htmlReport = true
        htmlOutput = file("lint-report.html")
        textReport = true
        absolutePaths = false
        lintConfig = file("lint.xml")
    }
}

dependencies {

//    Autogenerate
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

//    Koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation(libs.koin.core)

//    Koin tests
    implementation(libs.koin.test)
    implementation(libs.koin.test.junit4)
    implementation(libs.koin.android.test)

//    Test coroutines
    implementation(libs.kotlinx.coroutines.test)

//    Lint
    lintChecks(libs.compose.lint.checks)

//    Coroutines
    implementation(libs.kotlinx.coroutines.android)

//    Navigation
    implementation (libs.androidx.navigation.compose)

//    Splash screen
    implementation(libs.androidx.core.splashscreen)

//    РСЯ
    implementation(libs.mobileads)

//    Lottie
    implementation(libs.lottie.compose)

//    Corner smoothing
    implementation(libs.smooth.corner.rect.android.compose)

//    Google fonts
    implementation(libs.androidx.ui.text.google.fonts)

//    PDF
    implementation(libs.pdfbox)

//    Modules
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":lottie-store"))
    implementation(project(":local-store"))
}