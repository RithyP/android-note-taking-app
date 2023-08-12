package com.core.network.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun getGson(): Gson = GsonBuilder().serializeNulls().setLenient().disableHtmlEscaping().create()

    @Provides
    @Singleton
    fun providesOkHttpInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val original: Request = chain.request()
            val requestBuilder: Request.Builder =
                original.newBuilder().addHeader("Content-Type", "application/json")
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
//        loggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
            .addInterceptor(interceptor).callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://a-note-taking-app-5ec39-default-rtdb.asia-southeast1.firebasedatabase.app")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).disableHtmlEscaping()
                    .create()
            )
        ).client(okHttpClient).build()

}