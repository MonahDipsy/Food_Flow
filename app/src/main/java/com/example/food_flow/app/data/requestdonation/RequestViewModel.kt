import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.food_flow.app.data.requestdonation.Request
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class RequestViewModel : ViewModel() {

    private val _requestInProgress = mutableStateOf(false)
    val requestInProgress: Boolean get() = _requestInProgress.value

    fun submitRequest(
        requestType: String,
        requestPurpose: String,
        contactNumber: String,
        deliveryPreference: String,
        foodPreference: String,
        selectedCounty: String
    ) {
        val requestData = mapOf(
            "requestType" to requestType,
            "requestPurpose" to requestPurpose,
            "contactNumber" to contactNumber,
            "deliveryPreference" to deliveryPreference,
            "foodPreference" to foodPreference,
            "selectedCounty" to selectedCounty
        )

        _requestInProgress.value = true

        // Access the Firebase database instance
        val database = Firebase.database

        // Get a reference to the "requests" node in the database
        val requestsRef = database.getReference("requests")

        // Push the request data to the database
        requestsRef.push().setValue(requestData)
            .addOnSuccessListener {
                println("Request data written successfully.")
                // Navigate to another screen or update UI as needed
            }
            .addOnFailureListener {
                println("Error writing request data to Firebase: $it")
                // Handle error case
            }
            .addOnCompleteListener {
                _requestInProgress.value = false
            }
    }
}
