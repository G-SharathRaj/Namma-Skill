package com.nammaskill.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nammaskill.ui.AnimatedBackground

@Composable
fun HomeScreen(navController: NavController) {

    var searchText by remember {
        mutableStateOf("")
    }

    val skills = listOf(
        "Electrician",
        "Mobile Repair",
        "Tailoring",
        "Coding",
        "Driving",
        "Beautician",
        "Agriculture",
        "Welding"
    )

    val filteredSkills = skills.filter {
        it.contains(searchText, ignoreCase = true)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "🚀 Namma-Skill",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Empowering Rural Youth Through Skills",
                color = Color(0xFFE2E8F0),
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(25.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0x33FFFFFF)
                )
            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "🎯 1200+ Students Trained",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Skill training for jobs, self-employment and future growth.",
                        color = Color(0xFFE2E8F0)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = searchText,

                onValueChange = {
                    searchText = it
                },

                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.White
                    )
                },

                label = {
                    Text(
                        "Search Skills",
                        color = Color.White
                    )
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(18.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "🔥 Trending Skills",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                items(filteredSkills) { skill ->

                    Card(

                        onClick = {
                            navController.navigate("details/$skill")
                        },

                        modifier = Modifier
                            .height(140.dp),

                        shape = RoundedCornerShape(22.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color(0x22FFFFFF)
                        )
                    ) {

                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = skill,
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}