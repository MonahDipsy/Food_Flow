package com.example.food_flow.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.app.data.homescreen.DataViewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun ViewDonationsScreen(dataViewModel: DataViewModel = viewModel()) {
    val getData = dataViewModel.state.value

    Column {
        Text(text = "Selected County: ${getData.selectedCounty}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Location Details: ${getData.location}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Contact Number: ${getData.contactNumber}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Pickup Time: ${getData.time}")

    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
}