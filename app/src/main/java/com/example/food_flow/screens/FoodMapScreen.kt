package com.example.food_flow.screens

import androidx.compose.runtime.Composable
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun FoodMapScreen(){
    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
}
