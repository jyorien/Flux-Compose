package com.example.flux_compose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flux_compose.R

@Composable
fun CustomAppBar(
    menuIcon: Int = R.drawable.ic_baseline_menu_24,
    screenName: String = "",
    profilePicture: @Composable () -> Unit = {
        Image(
            painter = painterResource(id = R.drawable.dummy),
            contentDescription = "Profile Picture"
        )
    }
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 28.dp)
    ) {
        Icon(painterResource(id = menuIcon), "Menu Button")
        Text(screenName, fontSize = 20.sp, fontWeight = FontWeight.W500)
        Box(
            modifier = Modifier
                .clip(RectangleShape)
                .size(42.dp)
        ) {
            profilePicture()
        }
    }
}