package com.example.kotlinbasics.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "reminder_table")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val message: String,
    val location_x: Int,
    val location_y: Int,
    val reminder_time: Int,
    val creation_time: Int,
    val creator_id: Int,
    val reminder_seen: Boolean
)
