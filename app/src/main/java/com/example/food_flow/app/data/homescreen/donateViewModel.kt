package com.example.food_flow.app.data.homescreen
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.food_flow.app.data.homescreen.DonationUIState
import com.example.food_flow.app.data.homescreen.DonationUIEvent
import com.example.food_flow.app.data.rules.Validator
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen

class DonateViewModel : ViewModel() {

    // Mutable state to hold the UI state of the donation screen
    var donationUIState = mutableStateOf(DonationUIState())

    // Mutable state to track if the donation process is in progress
    var donationInProgress = mutableStateOf(false)

    // Function to handle events from the UI
    fun onEvent(event: DonationUIEvent) {
        when (event) {
            is DonationUIEvent.LocationChanged -> {
                donationUIState.value = donationUIState.value.copy(
                    location = event.location
                )
                validateDataWithRules()
                printState()
            }
            is DonationUIEvent.QuantityChanged -> {
                // Handle quantity changed event
                // For now, let's just print the state
                printState()
            }
            DonationUIEvent.DonateButtonClicked -> {
                // Handle donate button clicked event
                donate()
            }
        }
    }
    private fun validateDataWithRules() {
    }

    private fun donate() {
        donationInProgress.value = true

        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }

    private fun printState() {

    }
}
