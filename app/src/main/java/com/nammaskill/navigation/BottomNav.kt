package com.nammaskill.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Favorite
sealed class BottomNav(
    val route: String,
    val title: String,

    val icon: ImageVector

) {

    object Home : BottomNav(
        "home",
        "Home",
        Icons.Default.Home
    )

    object Courses : BottomNav(
        "courses",
        "Courses",
        Icons.AutoMirrored.Filled.List    )

    object Map : BottomNav(
        "map",
        "Map",
        Icons.Default.LocationOn
    )

    object Profile : BottomNav(
        "profile",
        "Profile",
        Icons.Default.Person
    )
    object Success : BottomNav(
        "success",
        "Success",
        Icons.Default.Star
    )
    object Notifications : BottomNav(
        "notifications",
        "Alerts",
        Icons.Default.Notifications
    )
    object Favorites : BottomNav(

        "favorites",
        "Favorites",

        Icons.Default.Favorite
    )
}