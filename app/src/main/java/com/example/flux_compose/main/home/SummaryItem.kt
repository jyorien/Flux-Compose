package com.example.flux_compose.main.home

data class SummaryItem(
    val index: Int,
    val title: String,
    val amount: Float,
    val onClick: () -> Unit = {}
)
