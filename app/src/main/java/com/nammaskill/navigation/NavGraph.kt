package com.nammaskill.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.nammaskill.auth.LoginScreen
import com.nammaskill.auth.RegisterScreen
import com.nammaskill.screens.HomeScreen
import com.nammaskill.screens.MainScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nammaskill.viewmodel.AuthViewModel
import com.nammaskill.screens.SplashScreen
import com.nammaskill.viewmodel.ThemeViewModel
@Composable
fun NavGraph(themeViewModel: ThemeViewModel) {

    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()

    val startDestination =
        if (authViewModel.isUserLoggedIn()) {
            "home"
        } else {
            "login"
        }

    NavHost(
        navController = navController,
        startDestination = "splash"   ) {
        composable("splash") {
            SplashScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }
        composable("home") {
            MainScreen(themeViewModel)        }
    }
}