package com.example.food_flow.app.data.homescreen

data class Donation(
    val location: String,
    val date: String,
    val time: String,
    val contactNumber: String,
    val foodItems: List<String>,
    val selectedCounty: String
)
