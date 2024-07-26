package com.courseapp.littlelemonforyou.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.courseapp.littlelemonforyou.screens.HomeScreen
import com.courseapp.littlelemonforyou.screens.OnboardingScreen
import com.courseapp.littlelemonforyou.screens.ProfileScreen
import com.courseapp.littlelemonforyou.screens.TestScreen

@Composable
fun Navigation(context: Context, navController: NavHostController) {

    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    var startDestination = Onboarding.route

    if (sharedPreferences.getBoolean("userRegistered", false)) {
        startDestination = Home.route
    }

    NavHost(navController = navController, startDestination = startDestination){
        composable(Onboarding.route){
            OnboardingScreen(context, navController)
        }
        composable(Home.route){
            HomeScreen( navController)
        }
        composable(Profile.route){
            ProfileScreen(context, navController)
        }
        composable(Test.route){
            TestScreen(context, navController)
        }
    }
}