package com.example.flux_compose.main.home.total_expenses

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CircularBudgetProgress
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.CustomCalendar
import com.example.flux_compose.utils.getDaysOfCurrentWeek
import java.time.LocalDate

const val TOTAL_EXPENSES_SCREEN = "TOTAL_EXPENSES_SCREEN"

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TotalExpensesScreen(navController: NavController) {
    val date = LocalDate.now()
    val day = date.dayOfMonth
    val month = date.month
    val year = date.year
    val maxValue = 1800f
    val progress = remember { mutableStateOf(1200f) }
    Column(modifier = Modifier
        .padding(horizontal = 24.dp)
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        CustomAppBar(screenName = "Total Expenses", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = { navController.popBackStack() })
        CustomCalendar(days = getDaysOfCurrentWeek(), currentDay = day.toString(), month = month.toString(), year = year.toString())
        Spacer(modifier = Modifier.height(30.dp))
        CircularBudgetProgress(max = maxValue, progress = progress.value)
    }
}