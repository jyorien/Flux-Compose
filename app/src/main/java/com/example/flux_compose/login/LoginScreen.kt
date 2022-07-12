package com.example.flux_compose.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.flux_compose.R
import com.example.flux_compose.composables.FullWidthButton
import com.example.flux_compose.composables.FullWidthTextField
import com.example.flux_compose.main.MAIN_SCREEN

const val LOGIN_SCREEN = "login_screen"

@Composable
fun LoginScreen(navController: NavController) {
    val inputEmail = remember { mutableStateOf("") }
    val inputPassword = remember { mutableStateOf("") }
    Scaffold {
        Column(Modifier.fillMaxWidth()) {
            // Curved grey area on top
            CurvedGreyBackground()
            Spacer(modifier = Modifier.height(10.dp))
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
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
                FullWidthButton(onClick = { navController.navigate(MAIN_SCREEN) }) {
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
}
@Composable
fun CurvedGreyBackground() {
    val secondary = MaterialTheme.colors.secondary
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(width, 0f)
            lineTo(width, 500f)
//            lineTo(width.times(0.75f), height.times(0.84f))
            cubicTo(
                width,
                500f,

                width.times(.75f),
                height.times(.40f),

                width.times(.50f),
                height
            )

            cubicTo(
                width.times(.50f),
                height,

                width.times(.25f),
                height.times(1.40f),

                0f,
                height
            )


            close()
        }
        drawPath(path = path, color = secondary)
    }
}