package com.example.flux_compose.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FullWidthButton(onClick: () -> Unit, color: Color = MaterialTheme.colors.primary, content: @Composable () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(25),
        colors = ButtonDefaults.buttonColors(backgroundColor = color)
    ) {
        Box(modifier = Modifier.padding(vertical = 12.dp)) {
            content()
        }
    }
}