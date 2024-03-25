package com.example.food_flow.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.R
import com.example.food_flow.app.data.homescreen.DataViewModel
import com.example.food_flow.app.data.homescreen.Donation
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun ViewDonationsScreen(dataViewModel: DataViewModel = viewModel()) {
    val getData = dataViewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Column to hold heading and cards
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Heading
            HeadingTextComponent(value = stringResource(id = R.string.kenyafood))

            // Check if data is available
            if (getData != null) {
                // Display the first card
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    DonationCard(data = getData)
                }

                // Display the second card
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    DonationCard(
                        data = getData.copy(
                            donorId = "DONOR0002",
                            donationId = "TRANSREF25469",
                            selectedCounty = "Kisumu",
                            location = "Migosi Area",
                            contactNumber = "254755431414",
                            time = "Between 5pm to 6pm"

                        )
                    )
                }
            } else {
                // Data is still loading, display a loading indicator
                Text(text = "Loading...", modifier = Modifier.padding(16.dp))
            }
        }

        SystemBackButtonHandler {
            Food_FlowAppRouter.navigateTo(Screen.DonationsSubmittedScreen)
        }
    }
}

@Composable
fun DonationCard(data:Donation) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Donor ID: ${data.donorId}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Donation Reference No: ${data.donationId}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Selected County: ${data.selectedCounty}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Location Details: ${data.location}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Contact Number: ${data.contactNumber}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Pickup Time: ${data.time}")
    }
}