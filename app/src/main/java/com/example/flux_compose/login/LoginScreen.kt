package com.example.flux_compose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.FullWidthButton
import com.example.flux_compose.composables.FullWidthTextField

const val LOGIN_SCREEN = "login_screen"

@Composable
fun LoginScreen(navController: NavController) {
    val inputEmail = remember { mutableStateOf("") }
    val inputPassword = remember { mutableStateOf("") }
    Scaffold {
        // Curved grey area on top

        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            CurvedGreyBackground()
            Text("Flux", fontWeight = FontWeight.Bold, fontSize = 36.sp)
            Box(modifier = Modifier.height(30.dp))
            FullWidthButton(onClick = { /*TODO: Google Login*/ }, color = Color.White) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.google), "Google Login", Modifier.size(24.dp))
                    Box(modifier = Modifier.width(15.dp))
                    Text("Login with Google", fontSize = 16.sp)
                }
            }
            Box(modifier = Modifier.height(15.dp))
            FullWidthButton(onClick = { /*TODO: Apple Login*/ }, color = Color.Black) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.img), "Apple Login", Modifier.size(24.dp))
                    Box(modifier = Modifier.width(15.dp))
                    Text("Sign in with Apple", fontSize = 16.sp, color = Color.White)
                }
            }
            Box(Modifier.height(20.dp))
            Text("OR")
            Box(modifier = Modifier.height(20.dp))
            FullWidthTextField(inputEmail, "Email")
            Box(modifier = Modifier.height(20.dp))
            FullWidthTextField(
                inputPassword,
                "Password",
                trailingIcon = {
                    Icon(
                        painterResource(id = R.drawable.ic_baseline_remove_red_eye_24),
                        "Show Password",
                        modifier = Modifier
                            .padding(end = 35.dp)
                            .size(20.dp)
                    )
                },
                keyboardType = KeyboardType.Password
            )
            Box(modifier = Modifier.height(20.dp))
            FullWidthButton(onClick = { /*TODO: Sign in Button*/ }) {
                Row {
                    Text("Sign In")
                    Icon(
                        painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
                        "Continue Button",
                        Modifier.size(20.dp)
                    )
                }
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Forgot password?", color = Color(0x8D2E2E2E))
            }
            TextButton(onClick = { /*TODO*/ }) {
                Row {
                    Text("Don't have any account? ", color = Color(0x8D2E2E2E))
                    Text("Sign up",  color = Color(0xFF000000))
                }
            }
        }
    }
}

@Composable
fun CurvedGreyBackground() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.secondary)
                        .fillMaxWidth(0.5f)
                        .height(145.dp)
                )
            }
            Box(
                modifier = Modifier
                    .padding(top = 35.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.White)
                        .fillMaxWidth()
                        .height(150.dp)
                )

            }
        }
    }
}