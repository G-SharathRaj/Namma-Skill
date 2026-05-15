package com.nammaskill.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nammaskill.dao.CourseDao
import com.nammaskill.data.CourseEntity

@Database(
    entities = [CourseEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun courseDao(): CourseDao
}