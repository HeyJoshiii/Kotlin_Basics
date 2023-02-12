package com.example.kotlinbasics

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KotlinBasicsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}