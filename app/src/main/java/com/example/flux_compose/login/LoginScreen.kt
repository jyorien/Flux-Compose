package com.example.flux_compose.login

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

const val LOGIN_SCREEN = "login_screen"

@Composable
fun LoginScreen(navController: NavController) {
    Scaffold() {
        Text("login")
    }
}