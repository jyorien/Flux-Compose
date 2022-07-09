package com.example.flux_compose.main.home.add_goal

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.flux_compose.main.home.drawer.DrawerScreens

const val ADD_GOAL_SCREEN = "ADD_GOAL_SCREEN"

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun AddGoalScreen(navController: NavController) {
    val goalTitle = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val contributionType = remember { mutableStateOf("") }
    val deadline = remember { mutableStateOf("") }
    val contributionTypes = listOf("A", "B", "C")
    val isExpanded = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    val datePickerDialog = DatePickerDialog(context, { _, y, m, d ->
        deadline.value = "$d/$m/$y"

    }, year, month, dayOfMonth)
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize()
    ) {
        CustomAppBar(
            screenName = "Add Goal",
            menuIcon = R.drawable.ic_baseline_keyboard_backspace_24,
            onMenuItemClick = { navController.popBackStack() })
        Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.height(450.dp)) {
            FullWidthTextField(state = goalTitle, label = "Goal Title")
            FullWidthTextField(
                state = amount,
                label = "Amount",
                keyboardType = KeyboardType.Number,
                trailingIcon = { Icon(painterResource(id = R.drawable.ic_baseline_attach_money_24), "") })
            Column {
                FullWidthTextField(
                    state = contributionType,
                    label = "Contribution Type",
                    isEnabled = false,
                    modifier = Modifier.clickable { isExpanded.value = true },
                    trailingIcon = { Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")}
                )
                DropdownMenu(
                    expanded = isExpanded.value,
                    onDismissRequest = { isExpanded.value = false },
                    modifier = Modifier.width(200.dp)
                ) {
                    contributionTypes.forEach { type ->
                        DropdownMenuItem(
                            onClick = {
                                contributionType.value = type
                                isExpanded.value = false
                            },
                        ) {
                            Text(type)
                        }
                    }
                }
            }
            FullWidthTextField(state = deadline, label = "Deadline", trailingIcon = { Icon(painterResource(id = R.drawable.ic_baseline_calendar_month_24), "") }  ,isEnabled = false, modifier = Modifier.clickable {
                datePickerDialog.show()
            })
        }
        Box(modifier = Modifier.height(60.dp))
        FullWidthButton(onClick = { /*TODO*/ }) {
            Text("Add Goal")
        }
    }
}