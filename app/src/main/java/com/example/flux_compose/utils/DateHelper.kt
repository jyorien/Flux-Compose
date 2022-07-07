package com.example.flux_compose.utils

import android.util.Log
import java.util.*
import kotlin.time.Duration.Companion.days

fun getDaysOfCurrentWeek(): List<String> {
// set calendar
    val cal: Calendar = Calendar.getInstance()
    cal.set(Calendar.HOUR_OF_DAY, 0) // ! clear would not reset the hour of day !
    cal.clear(Calendar.MINUTE)
    cal.clear(Calendar.SECOND)
    cal.clear(Calendar.MILLISECOND)
// get start of this week in milliseconds
    cal.set(Calendar.DAY_OF_WEEK, cal.firstDayOfWeek)
// populate list
    val days = mutableListOf<String>()
    days.add(cal.get(Calendar.DAY_OF_MONTH).toString())
    for (i in 0 until 6) {
        cal.add(Calendar.DAY_OF_MONTH, 1)
        days.add(cal.get(Calendar.DAY_OF_MONTH).toString())
    }
    return days
}