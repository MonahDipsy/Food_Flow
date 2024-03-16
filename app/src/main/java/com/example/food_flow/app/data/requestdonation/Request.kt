package com.example.food_flow.app.data.requestdonation

data class Request(
    val requestType: String = "",
    val requestPurpose: String = "",
    val contactNumber: String = "",
    val deliveryPreference: String = "",
    val foodPreference: String = "",
    val selectedCounty: String = ""
)
