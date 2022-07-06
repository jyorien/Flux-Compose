package com.example.flux_compose.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.flux_compose.main.bottom_nav.*
import com.example.flux_compose.main.home.HOME_SCREEN
import com.example.flux_compose.main.home.HomeScreen

const val MAIN_SCREEN = "main_screen"
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
        NavHost(navController = navController, startDestination = HOME_SCREEN, modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
            composable(HOME_SCREEN) { HomeScreen(navController) }
            composable(STATS_SCREEN) { HomeScreen(navController)  }
            composable(ADD_SCREEN) { HomeScreen(navController)  }
            composable(NEWS_SCREEN) { HomeScreen(navController)  }
            composable(SETTINGS_SCREEN) { HomeScreen(navController)  }
        }
    }
}