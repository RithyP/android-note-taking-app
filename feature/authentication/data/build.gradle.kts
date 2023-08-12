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
    namespace = "com.feature.authentication.data"
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
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
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
    implementation(project(":feature:authentication:domain"))
    implementation(project(":core:common"))

    implementation(Deps.core)
    implementation(Deps.appCompat)

    implementation(FireBase.firebaseAuth)

    // Hilt
    implementation(DaggerHilt.hilt)
    implementation(DaggerHilt.hiltNavigation)
    kapt(DaggerHilt.hiltAndroidCompiler)
//    kapt(DaggerHilt.hiltCompiler)


    // Coroutines
    implementation(Coroutines.coroutineCore)
    implementation(Coroutines.coroutineAndroid)

    // Coroutine Lifecycle Scopes
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifecycleRuntime)
    // implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation(CoroutinesLifecycleScope.lifeCycleExtension)
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}