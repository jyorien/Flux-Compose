package com.example.flux_compose.main.add

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.FullWidthButton
import com.example.flux_compose.composables.FullWidthTextField
import com.example.flux_compose.main.MainViewModel

@Composable
fun AddItemScreen(viewModel: MainViewModel, navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val addScreenData: AddScreenData? = viewModel.addScreenDataMap[currentRoute]
    val titleController = remember { mutableStateOf("") }
    val amountController = remember { mutableStateOf("") }
    addScreenData?.let { data ->
        val categories = data.categories
        val stroke = Stroke(
            width = 2f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            CustomAppBar(screenName = "Add ${data.title}", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = {navController.popBackStack()})
            Box(Modifier.height(30.dp))
            FullWidthTextField(state = titleController, label = "${data.title} Title")
            Box(Modifier.height(30.dp))
            FullWidthTextField(state = amountController, label = "Amount")
            Box(Modifier.height(30.dp))
            Column(Modifier.padding(horizontal = 15.dp)) {
                Text("${data.title} Category")
                Box(modifier = Modifier.height(10.dp))
                LazyRow(content = {
                    items(categories.size) {
                        if (it == 0)  {
                            Box(
                                Modifier
                                    .size(80.dp, 50.dp)
                                    .padding(horizontal = 10.dp)
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
                        Box(Modifier.padding(horizontal = 10.dp)) {
                            CategoryItem(name = categories[it], isEven = (it + 1) % 2 == 0)
                        }
                    }
                })
                Box(modifier = Modifier.height(30.dp))
                if (currentRoute == ADD_EXPENSE_SCREEN) {
                    Text("Expense Resit Photo")
                    Box(modifier = Modifier.height(10.dp))
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clickable { }, contentAlignment = Alignment.Center) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            drawRoundRect(color = Color.Gray, style = stroke , cornerRadius = CornerRadius(24f, 24f))
                        }
                        Row {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24), contentDescription = "")
                            Box(modifier = Modifier.width(10.dp))
                            Text("Add Photo")
                        }
                    }
                }
                Box(modifier = Modifier.height(30.dp))
                FullWidthButton(onClick = { /*TODO*/ }) {
                    Text(text = "Add ${data.title}")
                }

            }
        }
    }

}

data class AddScreenData(
    val title: String,
    val categories: List<String>
)

@Composable
fun CategoryItem(name: String, isEven: Boolean) {
    Row(
        modifier = Modifier
            .size(100.dp, 50.dp)
            .clip(RoundedCornerShape(30))
            .background(if (isEven) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = name, color = Color.White)

    }
}