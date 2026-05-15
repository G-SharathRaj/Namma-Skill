package com.nammaskill.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CourseDetailScreen(
    navController: NavController,
    courseName: String
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = courseName,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Duration: 3 Months",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Eligibility: 10th Pass",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Training Center: Bengaluru Skill Hub",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Job Guarantee: Available",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                "This course provides hands-on practical training and helps rural youth gain employable skills.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate("apply/$courseName")
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Apply Now")
        }
    }
}