package com.example.flux_compose.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StepProgressIndicator(step: Int) {
    val circleModifier = Modifier.size(8.dp).clip(CircleShape)
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(32.dp)) {
     Box(modifier = circleModifier.background(if (step == 0) MaterialTheme.colors.primary else Color.Gray))
     Box(modifier = circleModifier.background(if (step == 1) MaterialTheme.colors.primary else Color.Gray))
     Box(modifier = circleModifier.background(if (step == 2) MaterialTheme.colors.primary else Color.Gray))
    }
}
