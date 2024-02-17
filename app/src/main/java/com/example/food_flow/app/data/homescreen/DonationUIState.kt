package com.example.food_flow.app.data.homescreen

data class DonationUIState(
    val location: String = "", // Initial value for location
    val quantity: Int = 0, // Initial value for quantity
    val locationError: String = "", // Error message for location validation
    val quantityError: String = "" // Error message for quantity validation
)