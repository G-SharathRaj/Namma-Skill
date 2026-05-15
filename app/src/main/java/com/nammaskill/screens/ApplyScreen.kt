package com.nammaskill.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore
import com.nammaskill.data.ApplicationModel
import androidx.navigation.NavController
import com.nammaskill.data.ApplicationStatus
@Composable
fun ApplyScreen(
    navController: NavController,
    courseName: String
){

    val context = LocalContext.current
    val firestore = FirebaseFirestore.getInstance()
    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Apply for $courseName",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text("Full Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = mobile,
            onValueChange = { mobile = it },
            label = {
                Text("Mobile Number")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = {
                Text("Location")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {

                val application = ApplicationModel(
                    name = name,
                    mobile = mobile,
                    location = location,
                    courseName = courseName
                )
                val applicationStatus = ApplicationStatus(
                    courseName = courseName,
                    status = "Under Review"
                )
                firestore.collection("applications")
                    .add(application)
                    .addOnSuccessListener {
                        firestore.collection("application_status")
                            .add(applicationStatus)

                        Toast.makeText(
                            context,
                            "Application Submitted Successfully",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate(
                            "summary/$name/$mobile/$location/$courseName"
                        )
                    }
                    .addOnFailureListener {

                        Toast.makeText(
                            context,
                            "Submission Failed",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Submit Application")
        }
    }
}