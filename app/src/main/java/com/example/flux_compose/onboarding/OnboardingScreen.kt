package com.example.flux_compose.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flux_compose.R

const val ONBOARDING_SCREEN = "onboarding_screen"

@Composable
fun OnboardingScreen() {
    val pageIndex = remember { mutableStateOf(0) }
    val onboardingDataList =
        listOf(
            OnboardingData(0, "Note Down Expenses",
                "Daily note your expenses to \n help manage money",
                R.drawable.coins),
            OnboardingData(1, "Simple Money Management",
                "Get your notification or alert when you overspend",
                R.drawable.manage),
            OnboardingData(
                2,
                "Easy to Track and Analyze",
                "Tracking your expenses help make sure you don't overspend",
                R.drawable.stonks
            )
        )
    Scaffold() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.height(150.dp))
            Box(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Image(painterResource(id = onboardingDataList[pageIndex.value].imageAsset), contentDescription = "Coins")
                    Text(onboardingDataList[pageIndex.value].title, fontSize = 24.sp, fontWeight = FontWeight.W500, textAlign = TextAlign.Center)
                    Box(Modifier.height(8.dp))
                    Text(onboardingDataList[pageIndex.value].description, fontSize = 16.sp, textAlign = TextAlign.Center)
                }
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, bottom = 32.dp)
                .fillMaxHeight(), verticalAlignment = Alignment.Bottom) {
                StepProgressIndicator(step = pageIndex.value)
                Button(onClick = {
                    pageIndex.value += 1
                }) {
                    Text("Next")
                }
            }


        }
    }
}