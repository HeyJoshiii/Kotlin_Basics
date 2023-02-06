package com.example.kotlinbasics.shared

import androidx.compose.runtime.Composable

var storedUsername = "Joshiii"
var storedPassword = "Joshiii"


fun loginInfo(): Pair<String, String> {
    return Pair(storedUsername, storedPassword)
}

fun setLoginInfo(s1: String, s2: String){
    storedUsername = s1
    storedPassword = s2
}