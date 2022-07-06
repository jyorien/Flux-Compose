package com.example.flux_compose.main.home

import androidx.compose.runtime.Composable


data class ActionItem(val icon: @Composable () -> Unit, val label: String)
