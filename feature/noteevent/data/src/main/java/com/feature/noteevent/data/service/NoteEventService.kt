package com.feature.noteevent.data.service

import com.feature.noteevent.data.model.NoteEventDto
import retrofit2.Response
import retrofit2.http.GET

interface NoteEventService {
    @GET("/notes.json")
    suspend fun getAllNotesList(): Response<List<NoteEventDto>>
}

