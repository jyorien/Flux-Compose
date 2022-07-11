package com.example.flux_compose.main.home.total_expenses

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CircularBudgetProgress
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.CustomCalendar
import com.example.flux_compose.composables.EntryListItem
import com.example.flux_compose.main.Entry
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

    val tabIndex = remember { mutableStateOf(0) }
    val tabTitles = listOf("Expenditure", "Categories")

    val entriesList = listOf(
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200", icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.fastfood
                ), "",
                tint = MaterialTheme.colors.primaryVariant
            )
        }),
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200", icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.fastfood
                ), "",
                tint = MaterialTheme.colors.primaryVariant
            )
        }),
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200", icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.fastfood
                ), "",
                tint = MaterialTheme.colors.primaryVariant
            )
        }),
    )
    Column {
        Column(modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            CustomAppBar(screenName = "Total Expenses", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = { navController.popBackStack() })
            CustomCalendar(days = getDaysOfCurrentWeek(), currentDay = day.toString(), month = month.toString(), year = year.toString())
            Spacer(modifier = Modifier.height(30.dp))
            CircularBudgetProgress(max = maxValue, progress = progress.value)

        }
        Spacer(modifier = Modifier.height(30.dp))
        TabRow(selectedTabIndex = tabIndex.value, backgroundColor = Color.Transparent) {
            tabTitles.forEachIndexed { index, s ->
                Tab(selected = tabIndex.value == index, onClick = {
                    tabIndex.value = index

                }, text = {Text(s)})
            }
        }
        when (tabIndex.value) {
            0 -> {
                LazyColumn(content = {
                    items(entriesList.size) {
                        EntryListItem(entry = entriesList[it])
                        Divider(Modifier.padding(vertical = 10.dp))
                    }
                }, modifier = Modifier.padding(12.dp))
            }
            1 -> {
                Text("helldo")
            }
        }
    }

}