plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
}

android {
    namespace = "com.rithyphavan.notetakingapp"
    compileSdk = 33

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    kotlin {
        jvmToolchain(8)
    }

    defaultConfig {
        applicationId = "com.rithyphavan.notetakingapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(Deps.constraintLayout)


    // Coroutines
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)

    // Coroutine Lifecycle Scopes
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifecycleRuntime)
    // implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation(CoroutinesLifecycleScope.lifeCycleExtension)

    // Retrofit network request
    implementation(RetrofitNetworkReq.retrofit)
    implementation(RetrofitNetworkReq.retrofitGsonConverter)
    implementation(RetrofitNetworkReq.loggingInterceptor)
    implementation(RetrofitNetworkReq.okHttp)
    implementation(RetrofitNetworkReq.scalersConverter)
//    implementation(Version.okio)

    // Hilt
    implementation(DaggerHilt.hilt)
    kapt(DaggerHilt.hiltAndroidCompiler)

    testImplementation(TestImplementation.jUnit)
    testImplementation(TestImplementation.jUnitJupiter)
    testImplementation(TestImplementation.jUnitJupiterApi)
    testImplementation(TestImplementation.mockitoCore)
    testImplementation(TestImplementation.mockitoInline)

    androidTestImplementation(AndroidTestImplementation.testExtJUnit)
    androidTestImplementation(AndroidTestImplementation.espressoCore)
    androidTestImplementation(AndroidTestImplementation.mockito)

}