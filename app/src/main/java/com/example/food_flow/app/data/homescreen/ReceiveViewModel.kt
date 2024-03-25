package com.example.food_flow.app.data.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ReceiveViewModel : ViewModel() {
    private val database = FirebaseDatabase.getInstance()
    private val donationsRef = database.getReference("donations")

    private val _donations = MutableLiveData<List<Donation>>()
    val donations: LiveData<List<Donation>> = _donations

    init {
        // Attach a ValueEventListener to retrieve data
        donationsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val donationList = mutableListOf<Donation>()
                for (donationSnapshot in snapshot.children) {
                    val donation = donationSnapshot.getValue(Donation::class.java)
                    donation?.let { donationList.add(it) }
                }
                _donations.postValue(donationList)
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }
}
