package com.example.flux_compose.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun CircularBudgetProgress(modifier: Modifier = Modifier, max: Float, progress: Float) {
    val primary = MaterialTheme.colors.primary
    val primaryVariant = MaterialTheme.colors.primaryVariant
    val progressAngle = progress / max * 360
    val progressPercentage = (progress / max * 100).roundToInt()
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally,  modifier = modifier
        .clip(shape = RoundedCornerShape(30f))
        .fillMaxWidth()
        .height(250.dp)
        .background(brush = Brush.verticalGradient(colors = listOf(Color(0x40DDDDDD), Color(0x51FFFFFF)))),) {
        Box(contentAlignment = Alignment.Center) {
            Canvas(modifier= Modifier
                .width(150.dp)
                .height(150.dp) , onDraw = {
                drawCircle(color = Color.LightGray, style = Stroke(12.dp.toPx(), cap = StrokeCap.Butt),)
                drawCircle(color = primaryVariant)
                drawArc(color = primary, startAngle = 270f, progressAngle, false, style = Stroke(12.dp.toPx(), cap = StrokeCap.Butt))
            })
            Text(text ="$${progress}", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Black)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text("You have spent $progressPercentage% of your total budget", fontWeight = FontWeight.W500, modifier = Modifier.width(200.dp), textAlign = TextAlign.Center)
    }


}