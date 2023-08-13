package com.feature.noteevent.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class NoteEvent(
    var date: String,
    var description: String,
    var invitee: List<String>?,
    var title: String,
) : Parcelable
