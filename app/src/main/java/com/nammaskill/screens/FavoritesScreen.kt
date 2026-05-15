package com.nammaskill.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FavoritesScreen(
    favoriteCourses: List<String>
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "❤️ Favorite Courses",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (favoriteCourses.isEmpty()) {

            Text(
                text = "No favorite courses yet."
            )
        }

        LazyColumn {

            items(favoriteCourses) { course ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        Icon(
                            Icons.Default.Favorite,
                            contentDescription = null,
                            tint = Color.Red
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = course,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}