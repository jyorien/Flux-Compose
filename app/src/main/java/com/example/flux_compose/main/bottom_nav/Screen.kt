package com.example.flux_compose.main.bottom_nav

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.flux_compose.main.home.HOME_SCREEN

sealed class Screen(val route: String, val title: String, val icon: @Composable () -> Unit) {
    object Home : Screen(route = HOME_SCREEN, title = "Home", icon = { Icon(Icons.Default.Home, "") })
    object Stats : Screen(route = STATS_SCREEN, title = "Stats", icon = { Icon(Icons.Default.Star, "") })
    object Add : Screen(
        route = ADD_SCREEN,
        title = "Add",
        icon = {
                Column(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(color = MaterialTheme.colors.primary)
                        .size(54.dp)
                    ,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) { Icon(Icons.Default.Add, "", Modifier.size(36.dp), tint = Color.White) }

        })

    object News : Screen(route = NEWS_SCREEN, title = "News", icon = { Icon(Icons.Default.Notifications, "") })
    object Settings : Screen(route = SETTINGS_SCREEN, title = "Settings", icon = { Icon(Icons.Default.Settings, "") })

}

const val STATS_SCREEN = "STATS_SCREEN"
const val ADD_SCREEN = "ADD_SCREEN"
const val NEWS_SCREEN = "NEWS_SCREEN"
const val SETTINGS_SCREEN = "SETTINGS_SCREEN"