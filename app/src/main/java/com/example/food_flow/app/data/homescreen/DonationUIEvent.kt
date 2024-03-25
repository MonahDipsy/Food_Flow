package com.example.food_flow.app.data.homescreen

sealed class DonationUIEvent {
    data class LocationChanged(val location: String) : DonationUIEvent()
    data class DateChanged(val date: String) : DonationUIEvent()
    data class FoodItemChanged(val foodItems: String) : DonationUIEvent()
    data class SelectedCountyChanged(val selectedCounty:String) : DonationUIEvent()
    data class TimeChanged(val time: String) : DonationUIEvent()
    data class ContactNumberChanged(val contactNumber: String) : DonationUIEvent()
    data class DonorIdChanged(val donorId: String) : DonationUIEvent()

    data object DonateButtonClicked : DonationUIEvent()

    data object DonationSubmitted : DonationUIEvent()
}
