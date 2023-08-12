package com.feature.noteevent.data.repository

import com.core.common.UiEvent
import com.feature.noteevent.data.model.NoteEventDto.Companion.mapNoteList
import com.feature.noteevent.data.service.NoteEventService
import com.feature.noteevent.domain.model.NoteEvent
import com.feature.noteevent.domain.repository.NoteEventRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteEventRepositoryImpl @Inject constructor(
    private val noteEventService: NoteEventService
) : NoteEventRepository {
    override suspend fun getNotesList(): UiEvent<List<NoteEvent>> {
        return try {
            val res = noteEventService.getAllNotesList()
            if (res.isSuccessful && res.body() != null) {
                UiEvent.Success(mapNoteList(res.body()!!))
            } else {
                UiEvent.Error()
            }
        } catch (e: Exception) {
            UiEvent.Error()
        }
    }
}