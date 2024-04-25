import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.food_flow.app.data.DonationUIState
import com.example.food_flow.app.data.homescreen.Donation
import com.example.food_flow.screens.FoodBank
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DonateViewModelFactory(private val userEmail: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DonateViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DonateViewModel(userEmail) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass}")
    }
}


data class DonationUIState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

class DonateViewModel(private val userEmail: String) : ViewModel() {

    private val _donationUIState = mutableStateOf(DonationUIState())
    val donationUIState: DonationUIState get() = _donationUIState.value

    private val _donationInProgress = mutableStateOf(false)
    val donationInProgress: Boolean get() = _donationInProgress.value

    fun submitDonation(
        location: String,
        date: String,
        time: String,
        contactNumber: String,
        foodItems: String,
        selectedCounty: String,
        userEmail: String,
        selectedFoodBank: String
    ) {
        if (!validateData(location, contactNumber, foodItems)) {
            return
        }

        val donationData = mapOf(
            "location" to location,
            "date" to date,
            "time" to time,
            "contactNumber" to contactNumber,
            "foodItems" to foodItems,
            "selectedCounty" to selectedCounty,
            "userEmail" to userEmail,
            "selectedFoodBank" to selectedFoodBank
        )

        _donationInProgress.value = true

        // Use Firebase Realtime Database for donation submission (assuming this is your choice)
        val database = Firebase.database
        val donationsRef = database.getReference("donations")
        donationsRef.push().setValue(donationData)
            .addOnSuccessListener {
                println("Donation data written successfully.")
                // Donation successful, update UI state or navigate accordingly
                _donationInProgress.value = false
            }
            .addOnFailureListener {
                println("Error writing donation data to Firebase: $it")
                // Handle error case, update UI state to show error message
                _donationInProgress.value = false
            }
    }

    private fun validateData(location: String, contactNumber: String, foodItems: String): Boolean {

        if (location.isEmpty() || contactNumber.isEmpty() || foodItems.isEmpty()) {
            _donationUIState.value = _donationUIState.value.copy(errorMessage = "Please fill in all required fields")
            return false
        }
        return true
    }

}


