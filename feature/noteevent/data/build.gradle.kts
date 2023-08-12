plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

kapt {
    correctErrorTypes = true
}

android {
    namespace = "com.feature.noteevent.data"
    compileSdk = 33

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

    implementation(project(":feature:noteevent:domain"))

    implementation(project(":core:common"))
    implementation(project(":core:network"))

    implementation(Deps.core)
    implementation(Deps.appCompat)

    // Hilt
    implementation(DaggerHilt.hilt)
    implementation(DaggerHilt.hiltNavigation)
    kapt(DaggerHilt.hiltAndroidCompiler)
//    kapt(DaggerHilt.hiltCompiler)

    // Coroutines
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)

    // Retrofit network request
    implementation(RetrofitNetworkReq.retrofit)
    implementation(RetrofitNetworkReq.retrofitGsonConverter)
    implementation(RetrofitNetworkReq.loggingInterceptor)
    implementation(RetrofitNetworkReq.okHttp)
    implementation(RetrofitNetworkReq.scalersConverter)

    // Coroutine Lifecycle Scopes
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifecycleRuntime)
    // implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation(CoroutinesLifecycleScope.lifeCycleExtension)
}