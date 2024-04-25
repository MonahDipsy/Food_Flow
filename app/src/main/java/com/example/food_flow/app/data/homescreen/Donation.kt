package com.example.food_flow.app.data.homescreen

data class Donation(
    val location: String = "",
    val date: String = "",
    val time: String = "",
    val contactNumber: String = "",
    val foodItems: String = "",
    val selectedCounty: String = "",
    val selectedFoodBank: String = "",
    val userEmail: String = "",
    var approved: Boolean = false,
    var rejected: Boolean = false

)

