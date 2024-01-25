package com.example.food_flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.food_flow.app.FoodDonationApp
import com.example.food_flow.screens.LoginScreen
import com.example.food_flow.screens.SignUpScreen
import com.example.food_flow.screens.TermsAndConditionsScreen
import com.example.food_flow.ui.theme.Food_FlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDonationApp()

        }
    }
}

