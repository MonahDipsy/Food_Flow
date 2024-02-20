package com.example.food_flow.app.data.homescreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class DataViewModel: ViewModel(){
    val state = mutableStateOf(Donation())

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
}
suspend fun getDataFromFireStore(): Donation {
      val db = FirebaseFirestore.getInstance()
      var donations = Donation()

    try {
        db.collection("donations").get().await().map{

            val result = it.toObject(Donation::class.java)
            donations = result
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")

}
    return donations
}

