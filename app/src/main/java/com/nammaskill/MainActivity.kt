package com.nammaskill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nammaskill.navigation.NavGraph
import com.nammaskill.ui.theme.NammaSkillTheme
import com.nammaskill.viewmodel.ThemeViewModel
import androidx.room.Room
import com.nammaskill.database.AppDatabase
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "nammaskill_db"
        ).build()

        setContent {

            val themeViewModel: ThemeViewModel = viewModel()

            NammaSkillTheme(
                darkTheme = themeViewModel.isDarkMode.value
            ) {

                NavGraph(themeViewModel)
            }
        }
    }
}