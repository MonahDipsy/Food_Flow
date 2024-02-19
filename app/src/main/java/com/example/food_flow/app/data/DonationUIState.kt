package com.example.food_flow.app.data

import com.example.food_flow.app.data.homescreen.DonationUIEvent

data class DonationUIState(
    var location: String = "",
    var date: String = "",
    var time: String = "",
    var contactNumber: String = "",
    var foodItems: String = "",
    var selectedCounty: String = "",

) {
    val value: DonationUIValues
        get() = DonationUIValues(
            location,
            date,
            time,
            contactNumber,
            foodItems,
            selectedCounty
        )
}

data class DonationUIValues(
    val location: String,
    val date: String,
    val time: String,
    val contactNumber: String,
    val foodItems: String,
    val selectedCounty: String,
)