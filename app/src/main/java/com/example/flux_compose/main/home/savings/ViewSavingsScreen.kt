package com.example.flux_compose.main.home.savings

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CircularBudgetProgress
import com.example.flux_compose.composables.CustomAppBar
import kotlin.math.roundToInt

const val VIEW_SAVINGS_SCREEN = "VIEW_SAVINGS_SCREEN"
@Composable
fun ViewSavingsScreen(navController: NavController) {
    Column(Modifier.padding(horizontal = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        CustomAppBar(screenName = "Savings", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = {navController.popBackStack()})
        Card(modifier = Modifier.fillMaxWidth(), elevation = 1.dp) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(30.dp)) {
                Text("Current Savings", fontWeight = FontWeight.Black, fontSize = 18.sp, modifier = Modifier.padding(vertical = 5.dp))
                Spacer(modifier = Modifier.height(5.dp))
                SavingsCircle(progress = 600f)
            }
        }
    }
}

@Composable
fun SavingsCircle(progress: Float) {
    val primaryVariant = MaterialTheme.colors.primaryVariant
    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier= Modifier
            .width(100.dp)
            .height(100.dp) , onDraw = {
            drawCircle(color = Color.LightGray, style = Stroke(15.dp.toPx(), cap = StrokeCap.Butt),)
            drawCircle(color = primaryVariant)
        })
        Text(text ="$${progress}", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Black)
    }
}