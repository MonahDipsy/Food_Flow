import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_flow.app.data.DonationUIState
import com.example.food_flow.app.data.homescreen.Donation
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DonateViewModel : ViewModel() {

    private val _donationUIState = mutableStateOf(DonationUIState())
    val donationUIState: DonationUIState get() = _donationUIState.value

    private val _donationInProgress = mutableStateOf(false)
    val donationInProgress: Boolean get() = _donationInProgress.value

    val state = mutableStateOf(Donation())

    init {
        getData()
    }

    fun submitDonation(
        location: String,
        date: String,
        time: String,
        contactNumber: String,
        foodItems: String,
        selectedCounty: String
    ) {
        val donationData = mapOf(
            "location" to location,
            "date" to date,
            "time" to time,
            "contactNumber" to contactNumber,
            "foodItems" to foodItems,
            "selectedCounty" to selectedCounty
        )

        _donationInProgress.value = true

        // Access the Firebase database instance
        val database = Firebase.database

        // Get a reference to the "donations" node in the database
        val donationsRef = database.getReference("donations")

        // Push the donation data to the database
        donationsRef.push().setValue(donationData)
            .addOnSuccessListener {
                println("Donation data written successfully.")
                // Navigate to another screen or update UI as needed
            }
            .addOnFailureListener {
                println("Error writing donation data to Firebase: $it")
                // Handle error case
            }
            .addOnCompleteListener {
                _donationInProgress.value = false
            }
    }

    private fun validateData(): Boolean {
        // Implement your validation logic here
        // Return true if data is valid, false otherwise
        return true
    }

    private fun validateFood(): Boolean {
        // Implement your food item validation logic here
        return true
    }


    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }

    init {
        getData()
    }

    private suspend fun getDataFromFireStore(): Donation {
        val db = FirebaseFirestore.getInstance()
        var Donations = Donation()

        try {
           db.collection("donations").get().await().map{

               val result = it.toObject(Donation::class.java)
               Donations = result
           }
        } catch (e: FirebaseFirestoreException) {
            Log.d("DonateViewModel", "getDataFromFireStore: $e")
        }

        return Donations
    }
}
