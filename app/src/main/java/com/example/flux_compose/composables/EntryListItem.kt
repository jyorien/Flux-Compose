package com.example.flux_compose.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.flux_compose.main.Entry

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EntryListItem(entry: Entry) {
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