package com.example.flux_compose.main.add

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.main.home.SummaryItem

const val ADD_SCREEN = "ADD_SCREEN"
const val ADD_INCOME_SCREEN = "ADD_INCOME_SCREEN"
const val ADD_EXPENSE_SCREEN = "ADD_EXPENSE_SCREEN"

@Composable
fun AddScreen(navController: NavController) {
    val actionItemList = listOf(
        AddActionItem("", ""),
        AddActionItem("Add Income", ADD_INCOME_SCREEN),
        AddActionItem("Add Expense", ADD_EXPENSE_SCREEN)
    )
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        CustomAppBar(screenName = "Add", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24)
        LazyRow(content = {
            items(actionItemList.size) {
                if (it == 0) {
                    // dashed effect
                    val stroke = Stroke(
                        width = 2f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                    // dashed box
                    Box(
                        Modifier
                            .size(80.dp, 80.dp)
                            .padding(horizontal = 5.dp)
                            .clickable { /* TODO: Add New Item */ },
                        contentAlignment = Alignment.Center
                    ) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawRoundRect(color = Color.Gray, style = stroke, cornerRadius = CornerRadius(24f, 24f))
                        }
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add Button", tint = Color.Gray)
                    }
                    return@items
                }
                AddActionButtons(
                    isEven = (it + 1) % 2 == 0,
                    addItem = actionItemList[it],
                    navController = navController
                )
            }
        }, verticalAlignment = Alignment.CenterVertically)
    }
}

@Composable
fun AddActionButtons(isEven: Boolean, addItem: AddActionItem, navController: NavController) {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = if (isEven) MaterialTheme.colors.primaryVariant else Color.White,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clickable { navController.navigate(addItem.route) }
    ) {
        Column(Modifier.padding(horizontal = 24.dp, vertical = 48.dp)) {
            Icon(
                painterResource(id = R.drawable.wallet),
                "Wallet Icon",
                Modifier.size(24.dp),
                tint = if (isEven) Color.White else Color.Black
            )
            Box(modifier = Modifier.height(10.dp))
            Text(addItem.title)
        }
    }
}