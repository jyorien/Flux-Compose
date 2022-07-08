package com.example.flux_compose.main.home.drawer

import com.example.flux_compose.main.home.add_goal.ADD_GOAL_SCREEN

sealed class DrawerScreens(val title: String, val route: String) {
    object AddGoalScreen : DrawerScreens("Add Goal", ADD_GOAL_SCREEN)
    object SetRemindersScreen : DrawerScreens("Set Reminders", ADD_GOAL_SCREEN)
    object NotificationsScreen : DrawerScreens("Notifications", ADD_GOAL_SCREEN)
}
