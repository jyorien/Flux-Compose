package com.example.flux_compose.main.home.reminders

import android.os.Build
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import java.time.LocalDate

const val VIEW_REMINDERS_SCREEN = "VIEW_REMINDERS_SCREEN"
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ViewRemindersScreen(navController: NavController) {
    val reminders = listOf(
        Reminder(
            name = "Bill Payment",
            amount = "200",
            reminderDate = LocalDate.now().minusDays(10),
            dueDate = LocalDate.now().minusDays(10)
        ),
        Reminder(
            name = "Car Loan",
            amount = "600",
            reminderDate = LocalDate.now().minusDays(8),
            dueDate = LocalDate.now().minusDays(2)
        ),
        Reminder(
            name = "iPhone 12 Pro",
            amount = "400",
            reminderDate = LocalDate.now().minusDays(20),
            dueDate = LocalDate.now().minusDays(10)
        ),
        Reminder(
            name = "New Bike",
            amount = "300",
            reminderDate = LocalDate.now().minusDays(20),
            dueDate = LocalDate.now().minusDays(5)
        ),

    )
    Column(Modifier.padding(horizontal = 24.dp)) {
        CustomAppBar(screenName = "Reminders", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick =  { navController.popBackStack() })
        LazyColumn(content = {
            items(reminders.size) {
                ReminderItem(reminder = reminders[it])
                Spacer(modifier = Modifier.height(20.dp))
            }
        })
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReminderItem(reminder: Reminder) {
    val reminderDate = reminder.reminderDate
    var reminderMonth = reminderDate.month.toString().lowercase()
    reminderMonth = reminderMonth.replaceFirst(reminderMonth[0], reminderMonth[0]-32).substring(IntRange(0,2))
    val dueDate = reminder.dueDate
    var dueMonth = dueDate.month.toString().lowercase()
    dueMonth = dueMonth.replaceFirst(dueMonth[0], dueMonth[0]-32).substring(IntRange(0,2))
    Card(modifier = Modifier.fillMaxWidth(), elevation = 2.dp, shape = RoundedCornerShape(10)) {
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 10.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Row {
                    Text("Reminder Date: ", fontWeight = FontWeight.W500, fontSize = 14.sp)
                    Text("${reminderDate.dayOfMonth} $reminderMonth ${reminderDate.year}", fontSize = 14.sp)
                }
                Icon(painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24), contentDescription = "")
            }
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(reminder.name, fontWeight = FontWeight.Black)
                    Text("$${reminder.amount}")
                }
                Column {
                    Text("Due on", fontSize = 12.sp)
                    Text("${dueDate.dayOfMonth} $dueMonth ${dueDate.year}", fontSize = 14.sp)
                }
            }
        }
    }
}
