package com.nammaskill.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.nammaskill.viewmodel.AuthViewModel
import com.nammaskill.viewmodel.ThemeViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.LaunchedEffect
import com.google.firebase.firestore.FirebaseFirestore
import com.nammaskill.data.ApplicationStatus
import androidx.compose.runtime.remember
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
@Composable
fun ProfileScreen(
    navController: NavController,
    themeViewModel: ThemeViewModel
){

    val authViewModel: AuthViewModel = viewModel()


    val firestore = FirebaseFirestore.getInstance()

    val statusList = remember {
        mutableStateListOf<ApplicationStatus>()
    }

    LaunchedEffect(Unit) {

        firestore.collection("application_status")

            .addSnapshotListener { value, error ->

                if (value != null) {

                    statusList.clear()

                    for (document in value.documents) {

                        val status =
                            document.toObject(
                                ApplicationStatus::class.java
                            )

                        if (status != null) {

                            statusList.add(status)
                        }
                    }
                }
            }
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE8F5E9),
                        Color.White
                    )
                )
            )

            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color(0xFF0F9D58)),

            contentAlignment = Alignment.Center
        ) {

            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(70.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "My Profile",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Email",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = FirebaseAuth
                        .getInstance()
                        .currentUser
                        ?.email ?: "No Email"                )


                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Skill Journey",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Empowering rural youth through skills 🚀"
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {
                themeViewModel.toggleTheme()
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Toggle Dark Mode")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "My Applications",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.height(60.dp)
        ) {

            items(statusList) { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),

                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = item.courseName,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(

                            text = "Status: ${item.status}",

                            color = when(item.status) {

                                "Approved" -> Color(0xFF0F9D58)

                                "Waiting List" -> Color(0xFFF4B400)

                                "Rejected" -> Color.Red

                                else -> Color(0xFF4285F4)
                            },

                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        val currentEmail =
            FirebaseAuth.getInstance()
                .currentUser
                ?.email

        if (
            currentEmail ==
            "rajsharath323@gmail.com"
        ) {

            Button(

                onClick = {
                    navController.navigate("admin")
                },

                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Open Admin Dashboard")
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {

                authViewModel.logout()

                navController.navigate("login") {

                    popUpTo(0)


                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Logout")
        }
    }
}