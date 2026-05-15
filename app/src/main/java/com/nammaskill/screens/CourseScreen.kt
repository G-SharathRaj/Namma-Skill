package com.nammaskill.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.nammaskill.viewmodel.FavoriteViewModel

data class CourseData(
    val title: String,
    val icon: String,
    val duration: String,
    val salary: String
)

@Composable
fun CourseScreen(
    navController: NavController,
    favoriteViewModel: FavoriteViewModel
) {

    var searchText by remember {
        mutableStateOf("")
    }

    val courseList = listOf(

        CourseData(
            "Electrician Training",
            "⚡",
            "6 Months",
            "₹18,000/month"
        ),

        CourseData(
            "Mobile Repair",
            "📱",
            "3 Months",
            "₹22,000/month"
        ),

        CourseData(
            "Tailoring",
            "🧵",
            "4 Months",
            "₹15,000/month"
        ),

        CourseData(
            "Coding",
            "💻",
            "8 Months",
            "₹45,000/month"
        ),

        CourseData(
            "Beautician",
            "💄",
            "5 Months",
            "₹20,000/month"
        ),

        CourseData(
            "Welding",
            "🔥",
            "6 Months",
            "₹25,000/month"
        ),

        CourseData(
            "Driving",
            "🚗",
            "2 Months",
            "₹30,000/month"
        )
    )

    val filteredCourses = courseList.filter {

        it.title.contains(
            searchText,
            ignoreCase = true
        )
    }

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
    ) {

        Text(
            text = "🚀 Explore Skills",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(16.dp)
        )

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
                    "Search Courses",
                    color = Color.White
                )
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),

            shape = RoundedCornerShape(18.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {

            items(filteredCourses) { course ->

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

                        Row(
                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Text(
                                text = course.icon,
                                fontSize = 42.sp
                            )

                            Spacer(
                                modifier = Modifier.width(16.dp)
                            )

                            Column {

                                Text(
                                    text = course.title,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )

                                Spacer(
                                    modifier = Modifier.height(6.dp)
                                )

                                Text(
                                    text =
                                        "Duration: ${course.duration}",

                                    color = Color.LightGray
                                )

                                Text(
                                    text =
                                        "Expected Salary: ${course.salary}",

                                    color = Color.Green
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(18.dp)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),

                            horizontalArrangement =
                                Arrangement.SpaceBetween
                        ) {

                            IconButton(

                                onClick = {

                                    favoriteViewModel
                                        .toggleFavorite(
                                            course.title
                                        )
                                }

                            ) {

                                Icon(

                                    imageVector = if (

                                        favoriteViewModel
                                            .favoriteCourses
                                            .contains(course.title)

                                    ) {

                                        Icons.Default.Favorite

                                    } else {

                                        Icons.Default
                                            .FavoriteBorder
                                    },

                                    contentDescription = null,

                                    tint = Color.Red
                                )
                            }

                            Button(

                                onClick = {

                                    navController.navigate(
                                        "details/${course.title}"
                                    )
                                },

                                shape = RoundedCornerShape(16.dp)
                            ) {

                                Text("View Details")
                            }
                        }
                    }
                }
            }
        }
    }
}