package com.example.kotlinbasics.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(
    modifier: Modifier,
    onProfileButtonClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            HomeAppBar(modifier = modifier,
                onProfileButtonClicked
                )
        },
        content = {

        }
    )
}


@Composable
fun HomeAppBar(modifier: Modifier, onProfileButtonClicked: () -> Unit) {
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
                text = "Home"
            )
            IconButton(
                onClick = onProfileButtonClicked,
                content = {
                    Icon(
                        modifier = modifier
                            .padding(8.dp)
                            .size(60.dp),
                        painter = rememberVectorPainter(Icons.Filled.Person),
                        contentDescription = "profile_image",
                    )
                }
            )
        }
        Divider(color = Color.Blue, thickness = 1.dp)
    }
}


@Preview
@Composable
fun PreviewHome() {
    HomeScreen(modifier = Modifier)
}