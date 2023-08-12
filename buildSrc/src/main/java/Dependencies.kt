object Version {
    const val core = "1.9.0"
    const val appCompat = "1.6.1"
    const val androidMaterial = "1.8.0"
    const val constraintLayout = "2.1.4"

    const val kotlinCoroutines = "1.6.4"

    const val coroutineLifecycleScope = "2.6.1"
    const val coroutineLifecycleExtension = "2.2.0"

    const val retrofit = "2.9.0"
    const val okHttp = "5.0.0-alpha.9"
    const val okio = "3.1.0"

    const val firebase = "22.1.1"

    const val hilt = "2.44"
    const val hiltNavigation = "1.0.0"

    const val jUnit = "4.13.2"
    const val jUnitJupiter = "5.8.2"
    const val mockitoCore = "3.10.0"
    const val mockitoInline = "2.13.0"

    const val testExtJUnit = "1.1.5"
    const val espressoCore = "3.5.1"

    const val navVersion = "2.5.3"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val androidMaterial = "com.google.android.material:material:${Version.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
}

object RetrofitNetworkReq {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okHttp}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
    const val scalersConverter = "com.squareup.retrofit2:converter-scalars:${Version.retrofit}"
    const val okio = "com.squareup.okio:okio:${Version.okio}"
}

object Coroutines {
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.kotlinCoroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.kotlinCoroutines}"
}

object CoroutinesLifecycleScope {
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.coroutineLifecycleScope}"
    const val lifecycleRuntime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Version.coroutineLifecycleScope}"
    const val lifeCycleExtension =
        "androidx.lifecycle:lifecycle-extensions:${Version.coroutineLifecycleExtension}"
}


object NavigationComponent {
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Version.navVersion}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger.hilt-compiler:${Version.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-fragment:${Version.hiltNavigation}"
}

object FireBase {
    const val firebaseAuth = "com.google.firebase:firebase-auth-ktx:${Version.firebase}"
}

object TestImplementation {
    const val jUnit = "junit:junit:${Version.jUnit}"
    const val jUnitJupiter = "org.junit.jupiter:junit-jupiter:${Version.jUnitJupiter}"
    const val jUnitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Version.jUnitJupiter}"
    const val mockitoCore = "org.mockito:mockito-core:${Version.mockitoCore}"
    const val mockitoInline = "org.mockito:mockito-inline:${Version.mockitoInline}"
}

object AndroidTestImplementation {
    const val testExtJUnit = "androidx.test.ext:junit:${Version.testExtJUnit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCore}"
    const val mockito = "org.mockito:mockito-android:${Version.mockitoCore}"
}
