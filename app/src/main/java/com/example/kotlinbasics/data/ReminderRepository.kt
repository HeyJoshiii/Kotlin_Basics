package com.example.kotlinbasics.data

import androidx.lifecycle.LiveData

interface ReminderRepository {
    suspend fun addReminder(reminder: Reminder)
}