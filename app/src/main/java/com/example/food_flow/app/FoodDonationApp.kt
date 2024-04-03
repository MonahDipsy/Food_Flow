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
import com.example.food_flow.screens.DonateScreen
import com.example.food_flow.screens.FoodBankScreen
import com.example.food_flow.screens.DonationsSubmittedScreen
import com.example.food_flow.screens.ReceiveScreen
import com.example.food_flow.screens.FoodMapScreen
import com.example.food_flow.screens.RejectDonationsScreen
import com.example.food_flow.screens.ViewDonationsScreen


@Composable
fun FoodDonationApp(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()


    Food_FlowAppRouter.navigateTo(Screen.SplashScreen)


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

                is Screen.DonateScreen -> {
                    DonateScreen()
                }

                is Screen.ReceiveScreen -> {
                    ReceiveScreen()
                }

                is Screen.FoodBankScreen -> {
                    FoodBankScreen()
                }

                is Screen.FoodMapScreen -> {
                    FoodMapScreen()

                }

                is Screen.DonationsSubmittedScreen -> {
                    DonationsSubmittedScreen()
                }
                is Screen.ViewDonationsScreen -> {
                    ViewDonationsScreen()
                }

                is Screen.RejectDonationScreen ->{
                    RejectDonationsScreen()
                }
            }
        }
    }
}
