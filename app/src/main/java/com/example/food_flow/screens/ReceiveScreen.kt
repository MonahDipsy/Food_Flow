package com.example.food_flow.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.R
import com.example.food_flow.app.data.homescreen.ReceiveViewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.food_flow.components.HeadingTextComponent
@Composable
fun ReceiveScreen(receiveViewModel: ReceiveViewModel = viewModel()) {
    val donations = receiveViewModel.donations.value ?: emptyList()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeadingTextComponent(value = stringResource(id = R.string.myDonations))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(donations) { donation ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color.Black),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(text = "County: ${donation.selectedCounty}")
                        Text(text = "Location Details: ${donation.location}")
                        Text(text = "Food Items: ${donation.foodItems}")
                        Text(text = "Pickup Date: ${donation.date}")
                        Text(text = "Pickup Time: ${donation.time}")
                        Text(text = "Contact Number: ${donation.contactNumber}")
                        Text(text = "Donor Email: ${donation.userEmail}")
                        Text(
                            text = "Status: **${
                                if (donation.approved) {
                                    "Approved"
                                } else if (!donation.approved && donation.rejected) {
                                    "Rejected"
                                } else {
                                    "Pending"
                                }
                            }**",
                            style = TextStyle(fontWeight = FontWeight.Bold)
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    Food_FlowAppRouter.navigateTo(Screen.ViewDonationsScreen)
                                    donation.approved = true // Update status to approved
                                    receiveViewModel.saveApprovedDonationToDatabase(donation) // Save to database
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 4.dp)
                            ) {
                                Text(text = "Accept Donation")
                            }

                            Button(
                                onClick = {
                                    Food_FlowAppRouter.navigateTo(Screen.RejectDonationScreen)
                                    donation.rejected = true // Update status to rejected
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 4.dp)
                            ) {
                                Text(text = "Reject Donation")
                            }
                        }
                    }
                }
            }
        }

        SystemBackButtonHandler {
            Food_FlowAppRouter.navigateTo(Screen.DonationsSubmittedScreen)
        }
    }
}
