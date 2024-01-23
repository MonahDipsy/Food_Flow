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
import com.example.food_flow.components.CheckBoxComponents
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.components.MyTextField
import com.example.food_flow.components.NormalTextComponent
import com.example.food_flow.components.PasswordTextField
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen

@Composable

fun SignUpScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)

    ){
    Column(modifier = Modifier.fillMaxSize()){
        NormalTextComponent(value = stringResource(id = R.string.hello) )
        HeadingTextComponent(value = stringResource(id = R.string.heading) )
        Spacer(modifier = Modifier.heightIn(20.dp))
        MyTextField(
            labelValue = stringResource(id = R.string.first_name),
            painterResource(id = R.drawable.profile)
            )
        MyTextField(
            labelValue = stringResource(id = R.string.last_name),
            painterResource = painterResource(id = R.drawable.profile)
        )
        MyTextField(
            labelValue = stringResource(id = R.string.email),
            painterResource = painterResource(id = R.drawable.email)
        )
        PasswordTextField(
            labelValue = stringResource(id = R.string.password),
            painterResource = painterResource(id = R.drawable.lock)
        )
        CheckBoxComponents(value = stringResource(id = R.string.terms_and_conditions),
            onTextSelected = {
                Food_FlowAppRouter.navigateTo(Screen.TermsAndConditionsScreen)

            } )
        Spacer(modifier = Modifier.heightIn(80.dp))
        ButtonComponent(value = stringResource(id = R.string.register))


      }
    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}