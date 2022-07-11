package com.example.flux_compose.main.home.notifications

import androidx.compose.runtime.Composable

data class Notification(
    val name: String,
    val description: String,
    val time: String,
    val icon: @Composable () -> Unit
)
