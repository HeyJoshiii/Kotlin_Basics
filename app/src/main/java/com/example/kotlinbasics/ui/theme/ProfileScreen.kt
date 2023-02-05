package com.example.kotlinbasics.ui.theme

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen(
    modifier: Modifier,
) {
    Scaffold(
        topBar = {
            ProfileAppBar(modifier = modifier,
            )
        },
        content = {

        }
    )
}

@Composable
fun ProfileAppBar(modifier: Modifier){
    Text(text = "profile")
}