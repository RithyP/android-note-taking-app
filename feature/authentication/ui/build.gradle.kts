plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.feature.authentication.ui"
    compileSdk = 33

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":core:common"))

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(Deps.constraintLayout)


    // Coroutines
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)

    // Navigation
    implementation(NavigationComponent.navigationFragment)
    implementation(NavigationComponent.navigationUi)

    // Coroutine Lifecycle Scopes
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifecycleRuntime)
    // implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation(CoroutinesLifecycleScope.lifeCycleExtension)

    // Hilt
    implementation(DaggerHilt.hilt)
    implementation(DaggerHilt.hiltNavigation)
//    kapt(DaggerHilt.hiltAndroidCompiler)

    testImplementation(TestImplementation.jUnit)
    androidTestImplementation(AndroidTestImplementation.testExtJUnit)
    androidTestImplementation(AndroidTestImplementation.espressoCore)
}