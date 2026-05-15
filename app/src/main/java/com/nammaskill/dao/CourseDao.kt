package com.nammaskill.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nammaskill.data.CourseEntity

@Dao
interface CourseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourses(
        courses: List<CourseEntity>
    )

    @Query("SELECT * FROM courses")
    suspend fun getCourses(): List<CourseEntity>
}