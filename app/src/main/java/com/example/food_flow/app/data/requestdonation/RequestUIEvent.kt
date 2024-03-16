package com.example.food_flow.app.data.requestdonation
sealed class RequestUIEvent {
    data class RequestTypeChanged(val requestType: String) : RequestUIEvent()
    data class RequestPurposeChanged(val requestPurpose: String) : RequestUIEvent()
    data class ContactNumberChanged(val contactNumber: String) : RequestUIEvent()
    data class DeliveryPreferenceChanged(val deliveryPreference: String) : RequestUIEvent()
    data class FoodPreferenceChanged(val foodPreference: String) : RequestUIEvent()
    data class SelectedCountyChanged(val selectedCounty: String) : RequestUIEvent()

    data class SubmitRequestButton(val request: Request) : RequestUIEvent()

    data object RequestSubmitted : RequestUIEvent()
}


