package com.example.kotlinbasics.ui.theme

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.TextStyle
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
            LazyColumnDemo(modifier = modifier)
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

@Composable
fun LazyColumnDemo(modifier: Modifier) {
    val list = listOf(
        "Reminder1: Date", "Reminder2: Date", "Reminder3: Date", "Reminder4: Date"
    )
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = list, itemContent = { item ->
            Log.d("COMPOSE", "This get rendered $item")
            when (item) {
                "Reminder1: Date" -> {
                    Spacer(modifier = modifier.height(10.dp))
                    Button(onClick = {},
                    modifier = modifier.padding(6.dp).fillMaxWidth()) {
                        Text(text = item, style = TextStyle(fontSize = 20.sp))
                    }
                }
                "Reminder2: Date" -> {
                    Spacer(modifier = modifier.height(10.dp))
                    Button(onClick = {},
                        modifier = modifier.padding(6.dp).fillMaxWidth()) {
                        Text(text = item, style = TextStyle(fontSize = 20.sp))
                    }
                }
                "Reminder3: Date" -> {
                    Spacer(modifier = modifier.height(10.dp))
                    Button(onClick = {},
                        modifier = modifier.padding(6.dp).fillMaxWidth()) {
                        Text(text = item, style = TextStyle(fontSize = 20.sp))
                    }
                }
                "Reminder4: Date" -> {
                    Spacer(modifier = modifier.height(10.dp))
                    Button(onClick = {},
                        modifier = modifier.padding(6.dp).fillMaxWidth()) {
                        Text(text = item, style = TextStyle(fontSize = 20.sp))
                    }
                }
                else -> {
                    Spacer(modifier = modifier.height(10.dp))
                    Text(
                        text = item,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = modifier.padding(6.dp).fillMaxWidth()
                    )
                }
            }
        })
    }
}

@Preview
@Composable
fun PreviewHome() {
    HomeScreen(modifier = Modifier)
}