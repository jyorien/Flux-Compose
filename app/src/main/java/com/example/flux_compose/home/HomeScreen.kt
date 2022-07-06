package com.example.flux_compose.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import java.text.DecimalFormat

const val HOME_SCREEN = "home_screen"

@Composable
fun HomeScreen(navController: NavController) {
    val summaryItemList = listOf(
        SummaryItem(index = 0, title = "Total Salary", amount = 1800f),
        SummaryItem(index = 1, title = "Total Expense", 1800.5f),
        SummaryItem(index = 1, title = "Monthly Expense", 1800.294f),
    )
    Scaffold {
        Column(modifier = Modifier.padding(horizontal = 32.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 28.dp)
            ) {
                Icon(painterResource(id = R.drawable.ic_baseline_menu_24), "Menu Button")
                Box(
                    modifier = Modifier
                        .clip(RectangleShape)
                        .size(42.dp)
                ) {
                    Image(painter = painterResource(id = R.drawable.dummy), contentDescription = "Profile Picture")
                }
            }
            Text("Overview", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Box(modifier = Modifier.height(15.dp))
            LazyRow(content = {
                items(summaryItemList.size) {
                    HomeSummaryCard(isEven = (it + 1) % 2 == 0, summaryItem = summaryItemList[it])
                }
            })

        }
    }
}

@Composable
fun HomeSummaryCard(isEven: Boolean, summaryItem: SummaryItem) {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(20.dp),
        backgroundColor = if (isEven) MaterialTheme.colors.primaryVariant else Color.White,
        modifier = Modifier.padding(end = 20.dp)
    ) {
        Column(Modifier.padding(horizontal = 24.dp, vertical = 24.dp)) {
            Icon(
                painterResource(id = R.drawable.wallet),
                "Wallet Icon",
                Modifier.size(24.dp),
                tint = if (isEven) Color.White else Color.Black
            )
            Box(modifier = Modifier.height(10.dp))
            Text(summaryItem.title)
            Box(Modifier.height(30.dp))
            Text("$", fontWeight = FontWeight.Black, fontSize = 20.sp)
            Box(modifier = Modifier.height(2.dp))
            Text("%.2f".format(summaryItem.amount), fontWeight = FontWeight.Black, fontSize = 20.sp)
        }
    }
}