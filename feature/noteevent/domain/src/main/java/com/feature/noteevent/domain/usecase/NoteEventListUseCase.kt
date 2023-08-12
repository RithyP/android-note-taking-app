package com.feature.noteevent.domain.usecase

import com.core.common.UiEvent
import com.feature.noteevent.domain.model.NoteEvent
import com.feature.noteevent.domain.repository.NoteEventRepository
import javax.inject.Inject

class NoteEventListUseCase @Inject constructor(
    private val noteEventRepository: NoteEventRepository
) {

    suspend operator fun invoke(): UiEvent<List<NoteEvent>> {
        return noteEventRepository.getNotesList()
    }
}