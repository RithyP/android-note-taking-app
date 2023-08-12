plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("com.google.gms.google-services")
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

    implementation(project(":feature:authentication:ui"))
    implementation(project(":feature:authentication:domain"))
    implementation(project(":feature:authentication:data"))

    implementation(project(":feature:noteevent:ui"))
    implementation(project(":feature:noteevent:domain"))
    implementation(project(":feature:noteevent:data"))
    implementation(project(":core:common"))

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

    // Navigation
    implementation(NavigationComponent.navigationFragment)
    implementation(NavigationComponent.navigationUi)

    // Hilt
    implementation(DaggerHilt.hilt)
    implementation(DaggerHilt.hiltNavigation)
    kapt(DaggerHilt.hiltAndroidCompiler)
//    kapt(DaggerHilt.hiltCompiler)

    testImplementation(TestImplementation.jUnit)
    testImplementation(TestImplementation.jUnitJupiter)
    testImplementation(TestImplementation.jUnitJupiterApi)
    testImplementation(TestImplementation.mockitoCore)
    testImplementation(TestImplementation.mockitoInline)

    androidTestImplementation(AndroidTestImplementation.testExtJUnit)
    androidTestImplementation(AndroidTestImplementation.espressoCore)
    androidTestImplementation(AndroidTestImplementation.mockito)

}