package com.example.kotlinbasics.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            Text(text = "Username: Joshiii")
        }
    )
}

@Composable
fun ProfileAppBar(modifier: Modifier) {
    Column(

    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = modifier.padding(20.dp),
                fontSize = 24.sp,
                text = "Profile"
            )
            Icon(
                modifier = modifier
                    .padding(8.dp)
                    .size(60.dp),
                painter = rememberVectorPainter(Icons.Filled.Person),
                contentDescription = "profile_image"
            )
        }
            Divider(color = Color.Blue, thickness = 1.dp)
    }
}