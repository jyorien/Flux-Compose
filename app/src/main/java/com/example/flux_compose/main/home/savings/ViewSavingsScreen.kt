package com.example.flux_compose.main.home.savings

import android.os.Build
import android.widget.Space
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CircularBudgetProgress
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.main.latest_entries.LATEST_ENTRIES_SCREEN
import java.time.LocalDate
import java.util.*
import kotlin.math.roundToInt

const val VIEW_SAVINGS_SCREEN = "VIEW_SAVINGS_SCREEN"
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ViewSavingsScreen(navController: NavController) {
    val date = LocalDate.now()
    var month = date.month.toString().lowercase()
    month = month.replace(month[0], month[0]-32)
    val year = date.year
    Column(Modifier.padding(horizontal = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        CustomAppBar(screenName = "Savings", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = {navController.popBackStack()})
        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10) , elevation = 1.dp) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(30.dp)) {
                Text("Current Savings", fontWeight = FontWeight.Black, fontSize = 18.sp, modifier = Modifier.padding(vertical = 5.dp))
                Spacer(modifier = Modifier.height(5.dp))
                SavingsCircle(progress = 600f)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(10), elevation = 1.dp) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(30.dp)) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Row {
                        Icon(painter = painterResource(id = R.drawable.ic_baseline_calendar_month_24), contentDescription = "")
                        Spacer(modifier = Modifier.width(5.dp))
                        Text("$month $year", fontWeight = FontWeight.Black)
                    }
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(20))
                            .background(MaterialTheme.colors.primaryVariant)
                            .clickable {
                                navController.navigate(LATEST_ENTRIES_SCREEN)
                            },
                       contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                            "",
                            tint = Color.White
                        )
                    }
                }
                Text("Goal for this Month", fontWeight = FontWeight.W500, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(10.dp))
                GoalProgressBar(max = 500f, progress = 200f)
            }
        }
    }
}

@Composable
fun SavingsCircle(progress: Float) {
    val primaryVariant = MaterialTheme.colors.primaryVariant
    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier= Modifier
            .width(100.dp)
            .height(100.dp) , onDraw = {
            drawCircle(color = Color.LightGray, style = Stroke(15.dp.toPx(), cap = StrokeCap.Butt),)
            drawCircle(color = primaryVariant)
        })
        Text(text ="$${progress}", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Black)
    }
}

@Composable
fun GoalProgressBar(max: Float, progress: Float) {
    val primaryVariant = MaterialTheme.colors.primaryVariant
    val progressPercentage = progress / max
    Box {
        Box(contentAlignment = Alignment.CenterEnd) {
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .height(30.dp), onDraw = {
                drawRoundRect(color = Color.LightGray, cornerRadius = CornerRadius(20f,20f))
            })
            Text("$$max", fontWeight = FontWeight.W500, modifier = Modifier.padding(horizontal = 10.dp))
        }
        Box(contentAlignment = Alignment.CenterStart) {
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .height(30.dp), onDraw = {
                drawRoundRect(color = primaryVariant, size = Size(width = size.width * progressPercentage, height = size.height), cornerRadius = CornerRadius(20f, 20f))

            })
            Text("$$progress", color = Color.White, fontWeight = FontWeight.W500, modifier = Modifier.padding(horizontal = 10.dp))
        }


    }

}