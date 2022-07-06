package com.example.flux_compose.main

import androidx.compose.runtime.Composable
import java.time.LocalDate

data class Entry(val name: String, val date: LocalDate, val paymentMethod: String, val price: String, val icon: @Composable () -> Unit)
