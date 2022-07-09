package com.example.flux_compose.main.home.drawer

import com.example.flux_compose.main.home.add_goal.ADD_GOAL_SCREEN
import com.example.flux_compose.main.set_reminders.SET_REMINDER_SCREEN

sealed class DrawerScreens(val title: String, val route: String) {
    object AddGoalScreen : DrawerScreens("Add Goal", ADD_GOAL_SCREEN)
    object SetRemindersScreen : DrawerScreens("Set Reminders", SET_REMINDER_SCREEN)
    object NotificationsScreen : DrawerScreens("Notifications", ADD_GOAL_SCREEN)
}
