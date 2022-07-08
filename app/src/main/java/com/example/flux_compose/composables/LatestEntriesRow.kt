package com.example.flux_compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.main.latest_entries.LATEST_ENTRIES_SCREEN

@Composable
fun LatestEntriesRow(navController: NavController) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Latest Entries", fontSize = 24.sp, fontWeight = FontWeight.Black)
        Column(
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(20))
                .background(MaterialTheme.colors.primaryVariant)
                .clickable {
                    navController.navigate(LATEST_ENTRIES_SCREEN)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                "",
                tint = Color.White
            )
        }

    }
}