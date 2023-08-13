package com.feature.noteevent.data.di

import com.feature.noteevent.data.repository.NoteEventRepositoryImpl
import com.feature.noteevent.domain.repository.NoteEventRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NoteEventModule {

    @Binds
    abstract fun bindsNoteEventRepository(impl: NoteEventRepositoryImpl): NoteEventRepository
}