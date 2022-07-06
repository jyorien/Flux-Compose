package com.example.flux_compose.main.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
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
import com.example.flux_compose.main.Entry
import java.text.SimpleDateFormat
import java.time.LocalDate

const val HOME_SCREEN = "home_screen"

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen() {
    val summaryItemList = listOf(
        SummaryItem(index = 0, title = "Total Salary", amount = 1800f),
        SummaryItem(index = 1, title = "Total Expense", 1800.5f),
        SummaryItem(index = 1, title = "Monthly Expense", 1800.294f),
    )
    val actionItemList = listOf(
        ActionItem(icon = { Icon(Icons.Filled.Add, "Add") }, label = "Savings"),
        ActionItem(icon = { Icon(Icons.Filled.Notifications, "Notifs") }, "Reminders")
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
    Scaffold {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
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
            Box(modifier = Modifier.height(60.dp))
            LazyRow(content = {
                items(actionItemList.size) {
                    ActionButtonItem(actionItemList[it], (it + 1) % 2 == 0)
                }
            })
            Box(Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Latest Entries", fontSize = 24.sp, fontWeight = FontWeight.Black)
                Column(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(20))
                        .background(MaterialTheme.colors.primaryVariant)
                        .clickable {
                            // TODO: x route
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                        "",
                        tint = Color.White
                    )
                }

            }
            Box(Modifier.height(15.dp))
            LazyColumn(content = {
                items(entriesList.size) {
                    LatestEntry(entry = entriesList[it])
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
        modifier = Modifier.padding(horizontal = 10.dp)
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
            .height(120.dp),
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LatestEntry(entry: Entry) {
    val date = entry.date
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Row {
            Column(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(20))
                    .background(color = MaterialTheme.colors.secondary)
            ) {
                entry.icon()
            }
            Box(modifier = Modifier.width(15.dp))
            Column {
                Text(entry.name, fontWeight = FontWeight.Black)
                Text("${date.dayOfMonth} ${date.month.toString().slice(0..2)} ${date.year}")
            }

        }
        Column(horizontalAlignment = Alignment.End) {
            Text(entry.price, fontWeight = FontWeight.Black)
            Text(entry.paymentMethod)
        }
    }
}
