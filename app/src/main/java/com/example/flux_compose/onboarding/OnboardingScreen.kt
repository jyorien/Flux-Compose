package com.example.flux_compose.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingScreen() {
    Scaffold() {
        Column() {
            Text("Hello", fontSize = 60.sp)
        }
    }
}