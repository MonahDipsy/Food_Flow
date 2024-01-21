package com.example.food_flow.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_flow.ui.theme.BgColor
import com.example.food_flow.ui.theme.Primary
import com.example.food_flow.ui.theme.TextColor
import com.example.food_flow.ui.theme.ComponentShapes
import com.example.food_flow.R
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun NormalTextComponent(value:String){
        Text(text = value,
             modifier = Modifier
                 .fillMaxWidth()
                 .heightIn(min = 40.dp),
             style = TextStyle(
                 fontSize = 24.sp,
                 fontWeight = FontWeight.Normal,
                 fontStyle = FontStyle.Normal
             )
            , color = TextColor,
            textAlign = TextAlign.Center


        )

}

@Composable
fun HeadingTextComponent(value:String){
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        , color = TextColor,
        textAlign = TextAlign.Center


    )

}
@Composable
fun MyTextField(labelValue: String, painterResource: Painter) {

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(ComponentShapes.small)
            .background(color = BgColor),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Primary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
        ),
        keyboardActions = KeyboardActions.Default,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        }
    )
}

@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter) {

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(ComponentShapes.small)
            .background(color = BgColor),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = Primary,
            focusedBorderColor = Primary,
            focusedLabelColor = Primary,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisibility.value) {
                Icons.Filled.Visibility
            } else{
                Icons.Filled.VisibilityOff
            }

            var description = if(passwordVisibility.value){
                stringResource(id = R.string.hide_password)
            }else
                stringResource(id = R.string.show_password)

            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }){
                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if(passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation())
}

