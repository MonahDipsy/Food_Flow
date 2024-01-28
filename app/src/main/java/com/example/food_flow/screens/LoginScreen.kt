package com.example.food_flow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.food_flow.R
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.components.ClickableLoginTextComponent
import com.example.food_flow.components.DividerTextComponent
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.components.MyTextField
import com.example.food_flow.components.NormalTextComponent
import com.example.food_flow.components.PasswordTextField
import com.example.food_flow.components.UnderlinedTextComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)

    ){
        Column (modifier = Modifier.fillMaxSize()){
            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.welcome))
            Spacer(modifier = Modifier.heightIn(18.dp))

            MyTextField(labelValue = stringResource(id = R.string.email),
                        painterResource(id =R.drawable.email)  )


            PasswordTextField(labelValue = stringResource(id = R.string.password),
                painterResource(id =R.drawable.lock)  )

            Spacer(modifier = Modifier.heightIn(40.dp))

            UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))

            Spacer(modifier = Modifier.heightIn(35.dp))

            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.heightIn(25.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                Food_FlowAppRouter.navigateTo(Screen.SignUpScreen)

            })

        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview

@Composable
fun LoginScreenPreview(){
    LoginScreen()
}