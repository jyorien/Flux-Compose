package com.example.flux_compose.main.set_reminders

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.FullWidthTextField

const val SET_REMINDER_SCREEN = "SET_REMINDER_SCREEN"
@Composable
fun SetReminderScreen(navController: NavController) {
    val bill = remember { mutableStateOf("") }
    val billTypes = listOf("Car Loan", "Student Loan", "Spotify Subscription")
    val amount = remember { mutableStateOf("") }
    val frequency = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val isExpanded = remember { mutableStateOf(false) }
    Column(modifier = Modifier.padding(horizontal = 24.dp)) {
        CustomAppBar(menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = { navController.popBackStack() })
        Column {
            FullWidthTextField(state = bill, label = "Select Bill", trailingIcon = { Icon(Icons.Default.ArrowDropDown,"") }, isEnabled = false, modifier = Modifier.clickable { isExpanded.value = true })
            DropdownMenu(expanded = isExpanded.value, onDismissRequest = { isExpanded.value = false }) {
                billTypes.forEach { b ->
                    DropdownMenuItem(onClick = {
                        bill.value = b
                        isExpanded.value = false
                    }) {
                        Text(b)
                    }
                }
            }
        }
    }
}