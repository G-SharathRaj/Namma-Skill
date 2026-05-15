package com.nammaskill.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.nammaskill.navigation.BottomNav
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.nammaskill.screens.SuccessStoriesScreen
import com.nammaskill.screens.NotificationScreen
import com.nammaskill.viewmodel.ThemeViewModel
import com.nammaskill.screens.CandidateSummaryScreen
import com.nammaskill.screens.FavoritesScreen
import com.nammaskill.viewmodel.FavoriteViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nammaskill.screens.FavoritesScreen
@Composable
fun MainScreen(themeViewModel: ThemeViewModel) {

    val navController = rememberNavController()
    val favoriteViewModel: FavoriteViewModel =
        viewModel()
    val items = listOf(

        BottomNav.Home,
        BottomNav.Courses,
        BottomNav.Map,
        BottomNav.Success,
        BottomNav.Notifications,
        BottomNav.Favorites,
        BottomNav.Profile
    )

    Scaffold(

        bottomBar = {

            NavigationBar {

                val currentRoute =
                    navController.currentBackStackEntryAsState().value?.destination?.route

                items.forEach { item ->

                    NavigationBarItem(

                        selected = currentRoute == item.route,

                        onClick = {
                            navController.navigate(item.route)
                        },

                        icon = {
                            Icon(
                                item.icon,
                                contentDescription = item.title
                            )
                        },

                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }

    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("notifications") {
                NotificationScreen()
            }
            composable("home") {
                HomeScreen(navController)            }
            composable("success") {
                SuccessStoriesScreen()
            }
            composable("courses") {

                CourseScreen(
                    navController,
                    favoriteViewModel
                )
                   }
            composable("admin") {
                AdminScreen()
            }
            composable("map") {
                MapScreen()
            }
            composable("favorites") {

                FavoritesScreen(
                    favoriteViewModel.favoriteCourses
                )
            }
            composable("profile") {
                ProfileScreen(
                    navController,
                    themeViewModel
                )            }

            composable(
                route = "details/{courseName}",
                arguments = listOf(
                    navArgument("courseName") {
                        type = NavType.StringType
                    }
                )
            ) {

                val courseName =
                    it.arguments?.getString("courseName") ?: ""

                CourseDetailScreen(
                    navController,
                    courseName
                )
            }

            composable(
                route = "apply/{courseName}",
                arguments = listOf(
                    navArgument("courseName") {
                        type = NavType.StringType
                    }
                )
            ) {

                val courseName =
                    it.arguments?.getString("courseName") ?: ""

                ApplyScreen(
                    navController,
                    courseName
                )            }
            composable(

                route =
                    "summary/{name}/{mobile}/{location}/{courseName}",

                arguments = listOf(

                    navArgument("name") {
                        type = NavType.StringType
                    },

                    navArgument("mobile") {
                        type = NavType.StringType
                    },

                    navArgument("location") {
                        type = NavType.StringType
                    },

                    navArgument("courseName") {
                        type = NavType.StringType
                    }
                )
            ) {

                val name =
                    it.arguments?.getString("name") ?: ""

                val mobile =
                    it.arguments?.getString("mobile") ?: ""

                val location =
                    it.arguments?.getString("location") ?: ""

                val courseName =
                    it.arguments?.getString("courseName") ?: ""

                CandidateSummaryScreen(
                    name,
                    mobile,
                    location,
                    courseName
                )
            }
        }
    }
}