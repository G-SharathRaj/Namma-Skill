package com.nammaskill.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SuccessStory(
    val name: String,
    val skill: String,
    val salary: String,
    val story: String,
    val emoji: String
)

@Composable
fun SuccessStoriesScreen() {

    val stories = listOf(

        SuccessStory(
            "Ravi Kumar",
            "Electrician",
            "₹25,000/month",
            "Started his own electrical service business after training.",
            "⚡"
        ),

        SuccessStory(
            "Anjali",
            "Beautician",
            "₹30,000/month",
            "Opened a beauty studio and now trains other girls.",
            "💄"
        ),

        SuccessStory(
            "Rahul",
            "Coding",
            "₹50,000/month",
            "Got placed in a startup after coding training.",
            "💻"
        ),

        SuccessStory(
            "Suresh",
            "Driving",
            "₹28,000/month",
            "Now working as a commercial vehicle driver.",
            "🚗"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(

                Brush.verticalGradient(

                    listOf(
                        Color(0xFF020617),
                        Color(0xFF0F172A),
                        Color(0xFF1E293B)
                    )
                )
            )
            .padding(16.dp)
    ) {

        Text(
            text = "🎉 Success Stories",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text =
                "Real stories of rural youth empowered through skill training.",

            color = Color.LightGray
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(stories) { story ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),

                    shape = RoundedCornerShape(24.dp),

                    colors = CardDefaults.cardColors(
                        containerColor =
                            Color(0x22FFFFFF)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = story.emoji,
                            fontSize = 42.sp
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Text(
                            text = story.name,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = "Skill: ${story.skill}",
                            color = Color.Cyan
                        )

                        Text(
                            text =
                                "Current Income: ${story.salary}",

                            color = Color.Green
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Text(
                            text = story.story,
                            color = Color.LightGray,
                            lineHeight = 22.sp
                        )
                    }
                }
            }
        }
    }
}