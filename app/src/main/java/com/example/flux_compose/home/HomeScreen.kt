package com.example.flux_compose.home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

const val HOME_SCREEN = "home_screen"

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold {
       Text("home")
    }
}