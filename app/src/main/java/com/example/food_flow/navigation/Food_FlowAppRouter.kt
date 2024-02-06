package com.example.food_flow.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {


    object SplashScreen : Screen()
    object SignUpScreen : Screen()
    object TermsAndConditionsScreen : Screen()
    object LoginScreen : Screen ()
    object HomeScreen :  Screen ()
    object DonateScreen : Screen ()
    object FoodBankScreen : Screen ()
    object ReceiveScreen : Screen ()
    object FoodMapScreen : Screen ()

}


object Food_FlowAppRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SplashScreen)

    fun navigateTo(destination : Screen){
        currentScreen.value = destination
    }


}