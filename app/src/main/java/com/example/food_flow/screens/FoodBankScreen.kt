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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.food_flow.R
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.components.MyTextField
import com.example.food_flow.components.NormalTextComponent
import com.example.food_flow.components.PasswordTextField
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun FoodBankScreen() {
    var email by remember { mutableStateOf("") }
    var tokenID by remember { mutableStateOf("") }
    var isCredentialsValid by remember { mutableStateOf(false) }

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
                NormalTextComponent(value = stringResource(id = R.string.FoodBanklogin))

                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(
                    labelValue = stringResource(id = R.string.email),
                    painterResource = painterResource(id = R.drawable.email),
                    onTextChanged = { email = it } // Update the email state with the new text value
                )

                Spacer(modifier = Modifier.height(20.dp))

                MyTextField(
                    labelValue = stringResource(id = R.string.TokenID),
                    painterResource = painterResource(id = R.drawable.lock),
                    onTextChanged = { tokenID = it } // Update the tokenID state with the new text value
                )


                Spacer(modifier = Modifier.height(20.dp))



                ButtonComponent(
                    value = stringResource(id = R.string.verify),
                    onButtonClicked = {
                        isCredentialsValid =
                            email == "foodbanktest@gmail.com" && tokenID == "eyJhbG"
                        if (isCredentialsValid) {
                            Food_FlowAppRouter.navigateTo(Screen.DonationsSubmittedScreen)
                        }
                    },
                    isEnabled = email.isNotBlank() && tokenID.isNotBlank()
                )

                Spacer(modifier = Modifier.height(20.dp))

            }
        }
        }
    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
    }


