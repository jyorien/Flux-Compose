package com.example.flux_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flux_compose.home.HOME_SCREEN
import com.example.flux_compose.home.HomeScreen
import com.example.flux_compose.login.LOGIN_SCREEN
import com.example.flux_compose.login.LoginScreen
import com.example.flux_compose.onboarding.ONBOARDING_SCREEN
import com.example.flux_compose.onboarding.OnboardingScreen
import com.example.flux_compose.ui.theme.FluxComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FluxComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = ONBOARDING_SCREEN) {
                    composable(ONBOARDING_SCREEN) { OnboardingScreen(navController) }
                    composable(LOGIN_SCREEN) { LoginScreen(navController) }
                    composable(HOME_SCREEN) { HomeScreen(navController) }
                }
            }
        }
    }
}
