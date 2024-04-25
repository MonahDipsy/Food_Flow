package com.example.food_flow.app.data.homescreen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database

class ReceiveViewModel : ViewModel() {

    private val database = FirebaseDatabase.getInstance()
    private val donationsRef = database.getReference("donations")
    val firebaseDatabase = FirebaseDatabase.getInstance()
    private val _approvedDonations = MutableLiveData<List<Donation>>()
    val approvedDonations: LiveData<List<Donation>> = _approvedDonations


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
    fun saveApprovedDonationToDatabase(donation: Donation) {
        donation.approved = true

        // Generate a unique donation ID
        val donationId = generateDonationId(donations.value ?: emptyList())

        // Add the donation details to the approved_donations node in Firebase
        val databaseReference = firebaseDatabase.reference.child("approved_donations").child(donationId)
        databaseReference.setValue(donation)

        // Add the new donation to the list of approved donations
        val newApprovedDonations = (_approvedDonations.value ?: emptyList()) + donation
        _approvedDonations.postValue(newApprovedDonations)
    }


    fun generateDonationId(existingDonations: List<Donation>): String {
        // Calculate the next donation ID based on the number of existing approved donations
        val approvedDonationsCount = existingDonations.filter { it.approved }.size
        val nextId = approvedDonationsCount + 1
        return "DONATION$nextId"
    }

}