package com.nammaskill.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.google.firebase.auth.FirebaseAuth
@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember {
        Animatable(0.5f)
    }

    LaunchedEffect(true) {

        scale.animateTo(
            targetValue = 1f,

            animationSpec = tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            )
        )

        delay(2000)

        val currentUser =
            FirebaseAuth.getInstance().currentUser

        if (currentUser != null) {

            navController.navigate("home") {

                popUpTo("splash") {
                    inclusive = true
                }
            }

        } else {

            navController.navigate("login") {

                popUpTo("splash") {
                    inclusive = true
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF0F9D58),
                        Color(0xFF4285F4)
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.scale(scale.value)
        ) {

            Text(
                text = "Namma-Skill",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Empowering Rural Youth 🚀",
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}