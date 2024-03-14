package com.example.food_flow.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.food_flow.R
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun ReceiveScreen(){

    HeadingTextComponent(value = stringResource(id = R.string.RequestDonation))

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
}
