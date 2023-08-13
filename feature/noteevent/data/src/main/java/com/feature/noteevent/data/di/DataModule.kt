package com.feature.noteevent.data.di

import com.feature.noteevent.data.service.NoteEventService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNoteEventService(retrofit: Retrofit): NoteEventService {
        return retrofit.create(NoteEventService::class.java)
    }
}