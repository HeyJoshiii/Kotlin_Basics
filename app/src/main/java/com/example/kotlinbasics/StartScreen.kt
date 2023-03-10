package com.example.kotlinbasics

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinbasics.reminder.AddReminder
import com.example.kotlinbasics.ui.theme.HomeScreen
import com.example.kotlinbasics.ui.theme.LoginScreen
import com.example.kotlinbasics.ui.theme.ProfileScreen

/**
 * Enum Class that contains routes to navigate
 */
enum class StartScreen() {
    Login,
    Home,
    Profile,
    AddReminder
}

@Composable
fun KotlinApp(
    context: Context
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = StartScreen.Login.name,
        //modifier = Modifier.padding(60.dp)
    ) {
        composable(route = StartScreen.Login.name) {
            LoginScreen(
                onContinueButtonClicked = {navController.navigate(StartScreen.Home.name)},
                modifier = Modifier
            )
        }
        composable(route = StartScreen.Home.name){
            HomeScreen(
                modifier = Modifier,
                onProfileButtonClicked = {navController.navigate(StartScreen.Profile.name)},
                onReminderButtonClicked = {navController.navigate(StartScreen.AddReminder.name)}
            )
        }
        composable(route = StartScreen.Profile.name){
            ProfileScreen(
                modifier = Modifier,
                context = context,
                onLogoutButtonClicked = {navController.navigate(StartScreen.Login.name)}
            )
        }
        composable(route = StartScreen.AddReminder.name){
            AddReminder(
                modifier = Modifier,
                context = context,
                onBackButtonClicked = {navController.navigate(StartScreen.Home.name)}
            )
        }
    }
}