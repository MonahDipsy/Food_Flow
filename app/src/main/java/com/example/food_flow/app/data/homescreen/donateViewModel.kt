import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.food_flow.app.data.homescreen.DonationUIState
import com.example.food_flow.app.data.homescreen.DonationUIEvent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen

class DonateViewModel : ViewModel() {

    // Mutable state to hold the UI state of the donation screen
    private val _donationUIState = mutableStateOf(DonationUIState())
    val donationUIState: DonationUIState get() = _donationUIState.value

    // Mutable state to track if the donation process is in progress
    private val _donationInProgress = mutableStateOf(false)
    val donationInProgress: Boolean get() = _donationInProgress.value

    // Function to handle events from the UI
    fun onEvent(event: DonationUIEvent) {
        when (event) {
            is DonationUIEvent.LocationChanged -> {
                _donationUIState.value = _donationUIState.value.copy(
                    location = event.location
                )
                validateData() // Use validateData() instead of validateDataWithRules()
                printState()
            }
            is DonationUIEvent.DateChanged -> {
                _donationUIState.value = _donationUIState.value.copy(
                    date = event.date
                )
                validateData()
                printState()
            }
            is DonationUIEvent.FoodItemChanged -> {
                _donationUIState.value = _donationUIState.value.copy(
                    foodItems = event.foodItems
                )
                validateFood() // Define this function to validate food items
                printState()
            }
            is DonationUIEvent.TimeChanged -> {
                // Handle TimeChanged event
                _donationUIState.value = _donationUIState.value.copy(
                    time = event.time
                )
                validateData()
                printState()
            }
            is DonationUIEvent.ContactNumberChanged -> {
                // Handle ContactNumberChanged event
                _donationUIState.value = _donationUIState.value.copy(
                    contactNumber = event.contactNumber
                )
                validateData()
                printState()
            }
            DonationUIEvent.DonateButtonClicked -> {
                // Handle DonateButtonClicked event
                if (validateData()) { // Check if data is valid before donating
                    donate()
                }
            }
            is DonationUIEvent.DonationSubmitted -> {
                // Handle DonationSubmitted event
                // Perform any cleanup or UI updates related to the submission
                _donationInProgress.value = false // Set donationInProgress to false
                println("Donation Submitted")
            }
        }
    }

    private fun validateData(): Boolean {
        // Implement your validation logic here, ensuring all required fields are filled and meet format requirements
        // Return true if all data is valid, false otherwise
        return true // Replace with your actual validation logic
    }

    private fun validateFood(): Boolean {
        // Implement your food item validation logic here
        // Return true if food items are valid, false otherwise
        return true // Replace with your actual validation logic
    }

    private fun donate() {
        _donationInProgress.value = true // Set donationInProgress to true
        // Implement your donation logic here, potentially calling an API or database function
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }

    private fun printState() {
        // Implement your print state logic here (optional)
    }
}
