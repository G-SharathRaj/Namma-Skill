package com.nammaskill.ui

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun AnimatedBackground() {

    val infiniteTransition =
        rememberInfiniteTransition(
            label = ""
        )

    val color1 by infiniteTransition.animateColor(

        initialValue = Color(0xFF0F172A),

        targetValue = Color(0xFF312E81),

        animationSpec = infiniteRepeatable(

            animation = tween(
                durationMillis = 2500
            ),

            repeatMode = RepeatMode.Reverse
        ),

        label = ""
    )

    val color2 by infiniteTransition.animateColor(

        initialValue = Color(0xFF1E293B),

        targetValue = Color(0xFF2563EB),

        animationSpec = infiniteRepeatable(

            animation = tween(
                durationMillis = 3500
            ),

            repeatMode = RepeatMode.Reverse
        ),

        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(

                Brush.linearGradient(

                    colors = listOf(

                        Color(0xFF020617),

                        color1,

                        color2
                    )
                )
            )
    )
}