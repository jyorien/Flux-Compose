package com.example.flux_compose.main.home.add_goal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.main.home.drawer.DrawerScreens

const val  ADD_GOAL_SCREEN = "ADD_GOAL_SCREEN"
@Composable
fun AddGoalScreen(navController: NavController) {
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        CustomAppBar(screenName = "Add Goal", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick =  { navController.popBackStack() })
    }
}