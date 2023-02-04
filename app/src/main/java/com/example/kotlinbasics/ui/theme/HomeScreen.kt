package com.example.kotlinbasics.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun HomeScreen(

) {
    Scaffold(
        topBar = {
            HomeAppBar()
        },
        content = {

        }
    )
}

@Composable
fun HomeAppBar() {
    Row {
        Text(text = "Home")
    }
}