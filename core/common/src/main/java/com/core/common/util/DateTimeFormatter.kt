package com.core.common.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object DateTimeFormatter {
    fun convertCalendarToString(calendar: Calendar): String? {
        val format = SimpleDateFormat("yyyy, MMM dd, hh:mm a", Locale.US)
        return try {
            format.format(calendar.time)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}