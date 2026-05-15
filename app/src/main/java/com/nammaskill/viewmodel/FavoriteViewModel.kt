package com.nammaskill.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class FavoriteViewModel : ViewModel() {

    val favoriteCourses =
        mutableStateListOf<String>()

    fun toggleFavorite(course: String) {

        if (favoriteCourses.contains(course)) {

            favoriteCourses.remove(course)

        } else {

            favoriteCourses.add(course)
        }
    }
}