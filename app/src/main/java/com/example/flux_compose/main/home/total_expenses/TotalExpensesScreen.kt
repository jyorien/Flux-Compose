package com.example.flux_compose.main.home.total_expenses

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
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
    val primary = MaterialTheme.colors.primary
    val primaryVariant = MaterialTheme.colors.primaryVariant
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

    val categoryItems = listOf(
        CategoryItem(name = "Food", amount = 1080f, color = primary),
        CategoryItem(name = "Rent", amount = 180f, color = Color.Red),
        CategoryItem(name = "Etc", amount = 540f, color = primaryVariant),
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
                var max = 0f
                Column(Modifier.padding(vertical = 5.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f), contentAlignment = Alignment.Center) {
                        categoryItems.forEach { max += it.amount }
                        var startAngle = 0f
                        var isEven = false
                        categoryItems.forEach { categoryItem ->
                            val angle = categoryItem.amount / max * 180
                            Log.d("hello", "$isEven")
                            Canvas(modifier = Modifier
                                .width(if (isEven) 80.dp else 100.dp)
                                .height(if (isEven) 80.dp else 100.dp), onDraw = {
                                drawArc(color = categoryItem.color, startAngle = startAngle, angle, true, style = Fill)
                                startAngle += angle
                            })
                            isEven = !isEven
                        }
                    }
                    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                        categoryItems.forEach { categoryItem ->
                            val percentage = "%.1f".format(categoryItem.amount / max * 100)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier
                                    .clip(CircleShape)
                                    .size(5.dp)
                                    .background(categoryItem.color))
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(categoryItem.name)
                                Spacer(modifier = Modifier.width(5.dp))
                                Text("$percentage%")
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                }

            }
        }
    }
}

data class CategoryItem(
    val name: String,
    val amount: Float,
    val color: Color
)