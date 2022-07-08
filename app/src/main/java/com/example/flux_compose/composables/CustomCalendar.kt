package com.example.flux_compose.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flux_compose.R

@Composable
fun CustomCalendar(days: List<String>, currentDay: String) {
    val daysOfWeek = listOf("S", "M", "T", "W", "T", "F", "S")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(elevation = 2.dp, shape = RoundedCornerShape(10))
            .clip(RoundedCornerShape(10))
            .background(color = Color.White)
            .padding(vertical = 10.dp)
            .height(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = R.drawable.ic_baseline_calendar_month_24), contentDescription = "Calendar Icon", tint = MaterialTheme.colors.primary)
            Box(modifier = Modifier.width(10.dp))
            Text("July 2020", color = MaterialTheme.colors.primary)
        }
        Box(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            days.forEachIndexed { index, day ->
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(daysOfWeek[index])
                    Box(
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .clip(CircleShape)
                            .background(if (day == currentDay) MaterialTheme.colors.primary else Color.Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(day, color = if (day == currentDay) Color.White else Color.Black)
                    }


                }
            }
        }
    }

}