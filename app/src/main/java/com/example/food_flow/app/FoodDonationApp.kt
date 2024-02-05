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
import com.example.food_flow.screens.TermsAndConditionsScreen
@Composable
fun FoodDonationApp(homeViewModel: HomeViewModel = viewModel()) {
    homeViewModel.checkForActiveSession()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {if (homeViewModel.isUserLoggedIn.value == true) {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
        Crossfade(targetState = Food_FlowAppRouter.currentScreen, label = "") { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                else -> {""}
            }
        }
    }
}

