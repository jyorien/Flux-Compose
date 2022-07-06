package com.example.flux_compose

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flux_compose.login.LOGIN_SCREEN
import com.example.flux_compose.login.LoginScreen
import com.example.flux_compose.main.MAIN_SCREEN
import com.example.flux_compose.main.MainScreen
import com.example.flux_compose.onboarding.ONBOARDING_SCREEN
import com.example.flux_compose.onboarding.OnboardingScreen
import com.example.flux_compose.ui.theme.FluxComposeTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FluxComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = MAIN_SCREEN) {
                    composable(ONBOARDING_SCREEN) { OnboardingScreen(navController) }
                    composable(LOGIN_SCREEN) { LoginScreen(navController) }
                    composable(MAIN_SCREEN) { MainScreen() }
                }
            }
        }
    }
}
