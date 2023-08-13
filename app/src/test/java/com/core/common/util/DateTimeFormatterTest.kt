package com.core.common.util

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar
import java.util.Calendar.DAY_OF_MONTH
import java.util.Calendar.HOUR_OF_DAY
import java.util.Calendar.MINUTE
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR

class DateTimeFormatterTest {

    @Test
    fun `When pass calendar in morning time`() {
        val c = Calendar.getInstance()
        c.apply {
            set(DAY_OF_MONTH, 4)
            set(MONTH, 2)
            set(YEAR, 2023)
            set(HOUR_OF_DAY, 20)
            set(MINUTE, 4)
        }
        val formattedDate = DateTimeFormatter.convertCalendarToString(c)
        assertEquals(formattedDate, "2023, Mar 04, 08:04 PM")
    }
}