package com.example.food_flow.screens

import DonateViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun ViewDonationsScreen(donateViewModel: DonateViewModel = viewModel()) {
    val getData = donateViewModel.state.value

    // Check if data is not empty before accessing fields
    if (getData.location.isNotEmpty() && getData.foodItems.isNotEmpty()) {
        Text(text = getData.location)
        Text(text = getData.foodItems)
    } else {
        Text(text = "Loading...") // Show loading indicator when data is being fetched
    }
    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
}
