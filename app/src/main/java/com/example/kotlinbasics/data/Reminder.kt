package com.example.kotlinbasics.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(tableName = "reminder_table")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val location_x: Int,
    val location_y: Int,
    val reminder_time: Time,
    val creation_time: Time,
    val creator_id: Int,
    val reminder_seen: Boolean
)
