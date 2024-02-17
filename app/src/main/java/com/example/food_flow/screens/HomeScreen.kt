package com.example.food_flow.screens

import com.example.food_flow.app.data.home.HomeViewModel

import android.util.Log
import androidx.cardview.widget.CardView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.R
import com.example.food_flow.app.data.signup.SignupViewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(signupViewModel: SignupViewModel = viewModel()) {
    val firstName = signupViewModel.registrationUIState.value.firstName


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Hello $firstName,",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // First card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(0.8f)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.DonateScreen)
                        },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.donate),
                        contentDescription = "Donate Food",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Second card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(0.8f)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.ReceiveScreen)
                        },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.donate), // Replace with your image
                        contentDescription = "Receive Food",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Third card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(0.8f)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.FoodBankScreen)
                        },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bank), // Replace with your image
                        contentDescription = "Find Food Banks",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Fourth card
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .aspectRatio(0.8f)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.FoodMapScreen)
                        },
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.donate),
                        contentDescription = "View Food Maps",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.LoginScreen)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(signupViewModel = SignupViewModel())
}

