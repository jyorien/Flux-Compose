package com.example.flux_compose.main.home.savings

import androidx.compose.runtime.Composable

data class SavingItem(
    val name: String,
    val totalCost: Float,
    val progress: Float,
    val icon: @Composable () -> Unit
)
