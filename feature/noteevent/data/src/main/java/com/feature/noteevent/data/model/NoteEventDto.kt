package com.feature.noteevent.data.model

import com.feature.noteevent.domain.model.NoteEvent
import com.google.gson.annotations.SerializedName

data class NoteEventDto(
    @SerializedName("date") val date: String,
    @SerializedName("description") val description: String,
    @SerializedName("invitee") val invitee: List<String>?,
    @SerializedName("title") val title: String
) {
    companion object {
        fun mapNote(note: NoteEventDto): NoteEvent {
            return NoteEvent(note.date, note.description, note.invitee, note.title)
        }

        fun mapNoteList(notes: List<NoteEventDto>): List<NoteEvent> {
            return notes.map {
                mapNote(it)
            }
        }
    }
}