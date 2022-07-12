package com.example.flux_compose.main.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.EntryListItem
import com.example.flux_compose.composables.LatestEntriesRow
import com.example.flux_compose.main.Entry
import com.example.flux_compose.main.home.drawer.Drawer
import com.example.flux_compose.main.home.reminders.VIEW_REMINDERS_SCREEN
import com.example.flux_compose.main.home.savings.VIEW_SAVINGS_SCREEN
import com.example.flux_compose.main.home.total_expenses.TOTAL_EXPENSES_SCREEN
import kotlinx.coroutines.launch
import java.time.LocalDate

const val HOME_SCREEN = "home_screen"

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {
    val summaryItemList = listOf(
        SummaryItem(index = 0, title = "Total Salary", amount = 1800f),
        SummaryItem(index = 1, title = "Total Expense", 1800.5f) { navController.navigate(TOTAL_EXPENSES_SCREEN) },
        SummaryItem(index = 1, title = "Monthly Expense", 1800.294f),
    )
    val actionItemList = listOf(
        ActionItem(icon = { Icon(Icons.Filled.Add, "Add") }, label = "Savings", onClick = {
            navController.navigate(
                VIEW_SAVINGS_SCREEN
            )
        }),
        ActionItem(icon = { Icon(Icons.Filled.Notifications, "Notifs") }, "Reminders", onClick = {
            navController.navigate(
                VIEW_REMINDERS_SCREEN
            )
        })
    )
    val entriesList = listOf(
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200", icon = {
            Icon(
                painter = painterResource(
                    id = R.drawable.fastfood
                ), "",
                tint = MaterialTheme.colors.primaryVariant
            )
        })
    )
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val openDrawer = { scope.launch { drawerState.open() } }
    ModalDrawer(drawerContent = {
        Drawer(navController = navController)
    }, drawerState = drawerState, gesturesEnabled = drawerState.isOpen) {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            CustomAppBar(onMenuItemClick = { openDrawer() })
            Text("Overview", fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Box(modifier = Modifier.height(15.dp))
            LazyRow(content = {
                items(summaryItemList.size) {
                    HomeSummaryCard(isEven = (it + 1) % 2 == 0, summaryItem = summaryItemList[it])
                }
            })
            Box(modifier = Modifier.height(60.dp))
            LazyRow(content = {
                items(actionItemList.size) {
                    ActionButtonItem(actionItemList[it], (it + 1) % 2 == 0)
                }
            })
            Box(Modifier.height(15.dp))
            LatestEntriesRow(navController)
            Box(Modifier.height(15.dp))
            LazyColumn(content = {
                items(entriesList.size) {
                    EntryListItem(entry = entriesList[it])
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
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .clickable { summaryItem.onClick() }
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

@Composable
fun ActionButtonItem(actionItem: ActionItem, isEven: Boolean) {
    Card(
        backgroundColor = if (isEven) Color.White else MaterialTheme.colors.primaryVariant,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .width(140.dp)
            .height(120.dp)
            .clickable { actionItem.onClick() },
        shape = RoundedCornerShape(10)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Column(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(20))
                    .background(if (isEven) Color.LightGray else Color(0x52FFFFFF)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                actionItem.icon()
            }
            Text(actionItem.label, fontWeight = FontWeight.Black)
        }
    }
}
