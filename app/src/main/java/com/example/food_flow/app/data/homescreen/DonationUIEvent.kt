package com.example.food_flow.app.data.homescreen

sealed class DonationUIEvent {
    data class LocationChanged(val location: String) : DonationUIEvent()
    data class QuantityChanged(val quantity: Int) : DonationUIEvent()
    data object DonateButtonClicked : DonationUIEvent()


    data object DonationSubmitted: DonationUIEvent()
    }
