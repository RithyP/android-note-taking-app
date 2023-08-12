package com.feature.noteevent.domain.repository

import com.core.common.UiEvent
import com.feature.noteevent.domain.model.NoteEvent

interface NoteEventRepository {
    suspend fun getNotesList(): UiEvent<List<NoteEvent>>
}