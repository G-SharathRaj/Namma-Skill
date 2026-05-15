package com.nammaskill.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore
import com.nammaskill.data.ApplicationStatus
import com.nammaskill.screens.AdminScreen
@Composable
fun AdminScreen() {

    val firestore = FirebaseFirestore.getInstance()

    val applications = remember {
        mutableStateListOf<Pair<String, ApplicationStatus>>()
    }

    LaunchedEffect(Unit) {

        firestore.collection("application_status")
            .get()

            .addOnSuccessListener { result ->

                applications.clear()

                for (document in result) {

                    val item =
                        document.toObject(
                            ApplicationStatus::class.java
                        )

                    applications.add(
                        Pair(document.id, item)
                    )
                }
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "🛠 Admin Dashboard",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {

            items(applications) { item ->

                val docId = item.first

                val application = item.second

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = application.courseName,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Current Status: ${application.status}"
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row {

                            Button(

                                onClick = {

                                    firestore
                                        .collection("application_status")
                                        .document(docId)
                                        .update(
                                            "status",
                                            "Approved"
                                        )
                                },

                                colors = ButtonDefaults.buttonColors(
                                    containerColor =
                                        Color(0xFF0F9D58)
                                )
                            ) {

                                Text("Approve")
                            }

                            Spacer(
                                modifier = Modifier.width(12.dp)
                            )

                            Button(

                                onClick = {

                                    firestore
                                        .collection("application_status")
                                        .document(docId)
                                        .update(
                                            "status",
                                            "Rejected"
                                        )
                                },

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red
                                )
                            ) {

                                Text("Reject")
                            }
                        }
                    }
                }
            }
        }
    }
}