package com.example.flux_compose.main.home.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

private val screens = listOf(DrawerScreens.AddGoalScreen, DrawerScreens.SetRemindersScreen, DrawerScreens.NotificationsScreen)

@Composable
fun Drawer(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 24.dp, top = 48.dp)) {
        for (screen in screens) {
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = screen.title, modifier = Modifier.clickable { navController.navigate(screen.route) })
        }
    }
}