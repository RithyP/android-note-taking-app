package com.feature.authentication.data.di

import com.feature.authentication.data.repository.AuthRepositoryImpl
import com.feature.authentication.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AuthModule {
    @Provides
    fun bindAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }
}