package com.example.food_flow.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.food_flow.R
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.components.HeadingTextComponent
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

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()  // Align contents to the top
                .padding(horizontal = 28.dp, vertical = 64.dp),  // Adjust vertical padding
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top  // Align contents to the top
        ){
            HeadingTextComponent(value = stringResource(id = R.string.FoodBanklogin))
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier.size(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.foodflowlogo),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.email),
                onTextChanged = { email = it }
            )
            Spacer(modifier = Modifier.height(20.dp))
            MyTextField(
                labelValue = stringResource(id = R.string.TokenID),
                painterResource = painterResource(id = R.drawable.lock),
                onTextChanged = { tokenID = it }
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
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.LoginScreen)
    }
}


