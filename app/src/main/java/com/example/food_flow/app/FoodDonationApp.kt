package com.example.food_flow.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.app.data.home.HomeViewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.screens.LoginScreen
import com.example.food_flow.screens.SignUpScreen
import com.example.food_flow.screens.HomeScreen
import com.example.food_flow.screens.TermsAndConditionsScreen
import com.example.food_flow.screens.SplashScreen

@Composable
fun FoodDonationApp(homeViewModel: HomeViewModel = viewModel()) {
    // Assuming checkForActiveSession is responsible for checking the user's login status
    homeViewModel.checkForActiveSession()

    // Navigate to SplashScreen when the app starts
    Food_FlowAppRouter.navigateTo(Screen.SplashScreen)

    // Use a Crossfade to transition between screens
    Crossfade(targetState = Food_FlowAppRouter.currentScreen) { currentState ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.White
        ) {
            when (currentState.value) {
                is Screen.SplashScreen -> {
                    SplashScreen()
                }

                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }
    }
}
