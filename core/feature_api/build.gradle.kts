plugins {
    id("com.android.library")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.core.feature_api"
    compileSdk = 33

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
    implementation(Deps.core)
    implementation(Deps.appCompat)
    implementation(Deps.androidMaterial)
    implementation(Deps.constraintLayout)
    // Navigation
    implementation(NavigationComponent.navigationFragment)
    implementation(NavigationComponent.navigationUi)

    // Coroutine Lifecycle Scopes
    implementation(CoroutinesLifecycleScope.lifecycleViewModel)
    implementation(CoroutinesLifecycleScope.lifecycleRuntime)
    // implementation("android.arch.lifecycle:extensions:1.1.1")
    implementation(CoroutinesLifecycleScope.lifeCycleExtension)
    testImplementation(TestImplementation.jUnit)
    testImplementation(TestImplementation.jUnitJupiter)
    testImplementation(TestImplementation.jUnitJupiterApi)
    testImplementation(TestImplementation.mockitoCore)
    testImplementation(TestImplementation.mockitoInline)

    androidTestImplementation(AndroidTestImplementation.testExtJUnit)
    androidTestImplementation(AndroidTestImplementation.espressoCore)
    androidTestImplementation(AndroidTestImplementation.mockito)

}