package com.example.flux_compose.main.set_reminders

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.FullWidthButton
import com.example.flux_compose.composables.FullWidthTextField
import java.util.*

const val SET_REMINDER_SCREEN = "SET_REMINDER_SCREEN"

@Composable
fun SetReminderScreen(navController: NavController) {
    val bill = remember { mutableStateOf("") }
    val billTypes = listOf("Car Loan", "Student Loan", "Spotify Subscription")
    val amount = remember { mutableStateOf("") }
    val frequency = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val isBillExpanded = remember { mutableStateOf(false) }
    val isFrequencyExpanded = remember { mutableStateOf(false) }
    val frequencies = listOf("Weekly", "Monthly", "Every 3 months")
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val context = LocalContext.current
    val datePickerDialog = DatePickerDialog(context, { _, y, m, d ->
        date.value = "$d/$m/$y"
    }, year, month, day)
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        CustomAppBar(
            menuIcon = R.drawable.ic_baseline_keyboard_backspace_24,
            onMenuItemClick = { navController.popBackStack() },
            screenName = "Set Reminders"
        )
        Column(modifier = Modifier.height(450.dp), verticalArrangement = Arrangement.SpaceEvenly) {
            // select bill dropdown
            Column {
                FullWidthTextField(
                    state = bill,
                    label = "Select Bill",
                    trailingIcon = { Icon(Icons.Default.ArrowDropDown, "") },
                    isEnabled = false,
                    modifier = Modifier.clickable { isBillExpanded.value = true })
                DropdownMenu(expanded = isBillExpanded.value, onDismissRequest = { isBillExpanded.value = false }) {
                    billTypes.forEach { b ->
                        DropdownMenuItem(onClick = {
                            bill.value = b
                            isBillExpanded.value = false
                        }) {
                            Text(b)
                        }
                    }
                }
            }
            FullWidthTextField(
                state = amount,
                label = "Amount",
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_attach_money_24),
                        contentDescription = ""
                    )
                }, keyboardType = KeyboardType.Number)
            // frequency dropdown
            Column {
                FullWidthTextField(state = frequency, label = "Frequency", trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = ""
                    )
                }, isEnabled = false, modifier = Modifier.clickable { isFrequencyExpanded.value = true  })
                DropdownMenu(expanded = isFrequencyExpanded.value, onDismissRequest = { isFrequencyExpanded.value = false }) {
                    frequencies.forEach {
                        DropdownMenuItem(onClick = {
                            frequency.value = it
                            isFrequencyExpanded.value = false
                        }) {
                            Text(text = it)
                        }
                    }
                }
            }
            FullWidthTextField(state = date, label = "Date", isEnabled = false, modifier = Modifier.clickable {
                datePickerDialog.show()
            }, trailingIcon = { Icon(painter = painterResource(id = R.drawable.ic_baseline_calendar_month_24), contentDescription = "")})
        }
        Box(modifier = Modifier.height(60.dp))
        FullWidthButton(onClick = { /*TODO*/ }) {
            Text("Set Reminder")
        }

    }
}