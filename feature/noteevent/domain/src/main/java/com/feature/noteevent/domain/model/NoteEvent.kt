package com.feature.noteevent.domain.model

data class NoteEvent(
    val date: String,
    val description: String,
    val invitee: List<String>,
    val title: String,
)
