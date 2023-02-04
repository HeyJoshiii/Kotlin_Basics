package com.example.kotlinbasics

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinbasics.ui.theme.HomeScreen
import com.example.kotlinbasics.ui.theme.LoginScreen

/**
 * Enum Class that contains routes to navigate
 */
enum class StartScreen() {
    Login,
    Home
}

@Composable
fun KotlinApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = StartScreen.Login.name,
        //modifier = Modifier.padding(60.dp)
    ) {
        composable(route = StartScreen.Login.name) {
            LoginScreen(
                onContinueButtonClicked = {navController.navigate(StartScreen.Home.name)},
                modifier = Modifier.fillMaxWidth()
            )
        }
        composable(route = StartScreen.Home.name){
            HomeScreen(

            )
        }
    }
}