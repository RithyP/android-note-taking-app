package com.feature.noteevent.ui.notelisting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.UiEvent
import com.feature.noteevent.domain.model.NoteEvent
import com.feature.noteevent.domain.usecase.NoteEventListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListingViewModel @Inject constructor(
    private val noteListUseCase: NoteEventListUseCase
) : ViewModel() {

    private val _noteEventList = MutableStateFlow<UiEvent<List<NoteEvent>>?>(null)
    val noteEventList = _noteEventList.asStateFlow()

    fun getNoteEventList() {
        viewModelScope.launch {
            _noteEventList.value = UiEvent.Loading()
            _noteEventList.value = noteListUseCase.invoke()
        }
    }

    init {
        getNoteEventList()
    }

}