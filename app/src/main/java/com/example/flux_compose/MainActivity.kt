package com.example.flux_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                val navControler = rememberNavController()
                NavHost(navController =navControler , startDestination = ONBOARDING_SCREEN ) {
                    composable(ONBOARDING_SCREEN) { OnboardingScreen(navControler) }
                    composable(LOGIN_SCREEN) { LoginScreen(navControler) }
                }
            }
        }
    }
}
