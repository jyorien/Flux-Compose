package com.example.flux_compose.main.home.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.CustomAppBar
import com.example.flux_compose.ui.theme.fonts

const val NOTIFICATION_SCREEN = "NOTIFICATION_SCREEN"
@Composable
fun NotificationScreen(navController: NavController) {
    val notifs = listOf(
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
        Notification(name = "Food", description = "You just paid your food bill", time = "Just Now", icon = { Icon(
            painterResource(id = R.drawable.fastfood), contentDescription = "", tint = MaterialTheme.colors.primaryVariant) }),
    )
    Column(Modifier.padding(horizontal = 24.dp)) {
        CustomAppBar(screenName = "Notification", menuIcon = R.drawable.ic_baseline_keyboard_backspace_24, onMenuItemClick = { navController.popBackStack() })
        LazyColumn(content = {
            items(notifs.size) {
                NotificationItem(notification = notifs[it])
                Spacer(modifier = Modifier.height(15.dp))
            }
        })
    }
}

@Composable
fun NotificationItem(notification: Notification) {
    Card(elevation = 2.dp) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Row {
                Column(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(20))
                        .background(color = MaterialTheme.colors.secondary),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    notification.icon()
                }
                Box(modifier = Modifier.width(10.dp))
                Column {
                    Text(notification.name, fontWeight = FontWeight.Black)
                    Text(notification.description, fontSize = 12.sp)
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(notification.time, textAlign = TextAlign.End, fontSize = 10.sp)
                Icon(painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24), contentDescription = "")
            }
        }
    }
}