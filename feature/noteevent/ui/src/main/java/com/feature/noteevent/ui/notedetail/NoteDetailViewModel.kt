package com.feature.noteevent.ui.notedetail

import androidx.lifecycle.ViewModel
import com.feature.noteevent.domain.model.NoteEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteDetailViewModel : ViewModel() {

    private val _noteDetail = MutableStateFlow<NoteEvent?>(null)
    val noteDetail = _noteDetail.asStateFlow()

    fun setTitle(title: String) {
        _noteDetail.value?.title = title
    }

    fun setDateAndTime(dateTime: String) {
        _noteDetail.value?.date = dateTime
    }

    fun setDesc(desc: String) {
        _noteDetail.value?.description = desc
    }
}