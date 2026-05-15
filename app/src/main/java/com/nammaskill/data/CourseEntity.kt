package com.nammaskill.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courses")
data class CourseEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String
)