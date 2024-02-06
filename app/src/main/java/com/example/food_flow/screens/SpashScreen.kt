package com.example.food_flow.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.food_flow.R
import com.example.food_flow.app.data.login.LoginUIEvent
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.components.NormalTextComponent
import com.example.food_flow.components.SplashTextComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.foodflowlogo),
                contentDescription = "FoodFlow Logo",
                modifier = Modifier
                    .size(550.dp, 550.dp)
                    .padding(bottom = 16.dp)
            )

            SplashTextComponent(
                value = stringResource(id = R.string.WelcomeMessage),

            )
            Spacer(modifier = Modifier.height(50.dp))
            Box(
                modifier = Modifier.fillMaxSize(),

            ) {
                ButtonComponent(
                    value = stringResource(id = R.string.clickTocContinue),
                    onButtonClicked =  {Food_FlowAppRouter.navigateTo(Screen.LoginScreen)},
                    isEnabled = true
                )
            }


        }
    }
}
@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen()
}

