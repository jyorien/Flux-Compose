package com.example.flux_compose.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.flux_compose.main.add.*
import com.example.flux_compose.main.bottom_nav.*
import com.example.flux_compose.main.home.HOME_SCREEN
import com.example.flux_compose.main.home.HomeScreen

const val MAIN_SCREEN = "main_screen"
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(Screen.Home, Screen.Stats, Screen.Add, Screen.News, Screen.Settings)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(bottomBar = {
        BottomAppBar(backgroundColor = MaterialTheme.colors.secondary, modifier = Modifier.height(70.dp)) {
            BottomNavigation(backgroundColor = MaterialTheme.colors.secondary, modifier = Modifier.height(70.dp)) {
                bottomNavItems.forEach {
                    BottomNavigationItem(
                        selected = currentRoute == it.route,
                        onClick = { navController.navigate(it.route) },
                        icon = it.icon,
                        selectedContentColor = Color.Black,
                    unselectedContentColor = Color.LightGray)
                }
            }
        }
    }) {
        val viewModel: MainViewModel = viewModel()
        NavHost(navController = navController, startDestination = ADD_SCREEN, modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            composable(HOME_SCREEN) { HomeScreen() }
            composable(STATS_SCREEN) { HomeScreen() }
            composable(ADD_SCREEN) { AddScreen(navController) }
            composable(NEWS_SCREEN) { HomeScreen() }
            composable(SETTINGS_SCREEN) { HomeScreen() }
            composable(ADD_INCOME_SCREEN) { AddItemScreen(viewModel, navController) }
            composable(ADD_EXPENSE_SCREEN) { AddItemScreen(viewModel, navController) }
        }
    }
}