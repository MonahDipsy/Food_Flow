package com.example.food_flow

import android.app.Application
import com.google.firebase.FirebaseApp

class FoodFlowApp : Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}