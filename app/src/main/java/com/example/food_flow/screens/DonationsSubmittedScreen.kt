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
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import com.example.food_flow.R
import com.example.food_flow.components.HeadingTextComponent
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
@Composable
fun DonationsSubmittedScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            modifier = Modifier.padding(top = 100.dp), // Adjust top padding as needed
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadingTextComponent(value = stringResource(id = R.string.bankName))

            Box(
                modifier = Modifier.size(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kenyabank),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { Food_FlowAppRouter.navigateTo(Screen.ReceiveScreen)},
          ) {
                Text(text = "View your Donations",
                modifier = Modifier.padding(12.dp),
                color = Color.White,
                fontSize = 18.sp)

            }
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Track Mapped Donations",
                    modifier = Modifier.padding(12.dp),
                    color = Color.White,
                    fontSize = 18.sp)

            }
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.FoodBankScreen)
    }
}










