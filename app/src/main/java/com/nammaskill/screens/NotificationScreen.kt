package com.nammaskill.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NotificationItem(
    val title: String,
    val message: String
)

@Composable
fun NotificationScreen() {

    val notifications = listOf(

        NotificationItem(
            "New Electrician Batch",
            "New batch starts from Monday in Bengaluru."
        ),

        NotificationItem(
            "Government Skill Program",
            "Free tailoring training available for women."
        ),

        NotificationItem(
            "Job Opportunity",
            "Mobile repair technicians needed in Mysuru."
        ),

        NotificationItem(
            "Application Approved",
            "Your welding course application has been shortlisted."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row {

            Icon(
                Icons.Default.Notifications,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Notifications",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(notifications) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),

                    shape = RoundedCornerShape(16.dp),

                    elevation = CardDefaults.cardElevation(5.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = item.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(text = item.message)
                    }
                }
            }
        }
    }
}