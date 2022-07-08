package com.example.flux_compose.main.latest_entries

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.composables.EntryListItem
import com.example.flux_compose.main.Entry
import java.time.LocalDate

const val LATEST_ENTRIES_SCREEN = "LATEST_ENTRIES_SCREEN"

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LatestEntriesScreen(navController: NavController) {
    val latestEntries = listOf(
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
        Icon(
            painter = painterResource(id = R.drawable.fastfood),
            contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") },
        Entry(name = "Food", date = LocalDate.now(), paymentMethod = "Google Pay", price = "$200") {
            Icon(
                painter = painterResource(id = R.drawable.fastfood),
                contentDescription = "") }
    )
    Column(Modifier.padding(horizontal = 20.dp)) {
        CustomAppBar(
            screenName = "Entries",
            menuIcon = R.drawable.ic_baseline_keyboard_backspace_24,
            onMenuItemClick = { navController.popBackStack() })
        Text(text = "Latest Entries", fontWeight = FontWeight.Black, fontSize = 24.sp)
        LazyColumn(content = {
            items(latestEntries.size) {
                Box(modifier = Modifier.padding(vertical = 20.dp)) {
                    EntryListItem(entry = latestEntries[it])
                }
                if (it != latestEntries.size-1) Divider(color = Color.LightGray, thickness = 1.dp)
            }
        })
    }
}