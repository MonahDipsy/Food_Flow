package com.example.food_flow.app.data

import com.example.food_flow.app.data.homescreen.DonationUIEvent

data class DonationUIState(
    var location: String = "",
    var date: String = "",
    var time: String = "",
    var contactNumber: String = "",
    var foodItems: String = "",
    var selectedCounty: String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    var userEmail: String = ""

) {
    val value: DonationUIValues
        get() = DonationUIValues(
            location,
            date,
            time,
            contactNumber,
            foodItems,
            selectedCounty,
            userEmail
        )
}

data class DonationUIValues(
    val location: String,
    val date: String,
    val time: String,
    val contactNumber: String,
    val foodItems: String,
    val selectedCounty: String,
    val userEmail: String
)

