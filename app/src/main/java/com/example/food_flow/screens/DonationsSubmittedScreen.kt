package com.example.food_flow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import com.example.food_flow.R
import com.example.food_flow.components.MyTextField
import com.example.food_flow.components.NormalTextComponent

@Composable
fun DonationsSubmittedScreen(){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ButtonComponent(
                    value = stringResource(id = R.string.ViewDonations),
                    onButtonClicked = { /*TODO*/ })


                Spacer(modifier = Modifier.height(20.dp))


                ButtonComponent(
                    value = stringResource(id = R.string.TrackDonations),
                    onButtonClicked = { /*TODO*/ })


                Spacer(modifier = Modifier.height(20.dp))


                ButtonComponent(
                    value = stringResource(id = R.string.DonationRequests),
                    onButtonClicked = { /*TODO*/ })

            }

            SystemBackButtonHandler {
                Food_FlowAppRouter.navigateTo(Screen.FoodBankScreen)
            }


            }

        }
    }

