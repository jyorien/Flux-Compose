package com.example.flux_compose.main.home.reminders

import java.time.LocalDate

data class Reminder(
    val name: String,
    val amount: String,
    val reminderDate: LocalDate,
    val dueDate: LocalDate
)
