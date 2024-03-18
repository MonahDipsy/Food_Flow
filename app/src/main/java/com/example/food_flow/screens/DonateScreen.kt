package com.example.food_flow.screens

import DonateViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import com.example.food_flow.R
import com.example.food_flow.components.ButtonComponent

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DonateScreen(donateViewModel: DonateViewModel = viewModel()) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }

    var selectedCounty by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val counties = listOf(
        "Baringo", "Bomet", "Bungoma", "Busia", "Elgeyo-Marakwet", "Embu",
        "Garissa", "Homa Bay", "Isiolo", "Kajiado", "Kakamega", "Kericho",
        "Kiambu", "Kilifi", "Kirinyaga", "Kisii", "Kisumu", "Kitui", "Kwale",
        "Laikipia", "Lamu", "Machakos", "Makueni", "Mandera", "Marsabit",
        "Meru", "Migori", "Mombasa", "Murang'a", "Nairobi", "Nakuru", "Nandi",
        "Narok", "Nyeri", "Nyamira", "Nyandarua", "Samburu", "Siaya",
        "Taita-Taveta", "Tharaka-Nithi", "Trans Nzoia", "Turkana", "Uasin Gishu",
        "Vihiga", "Wajir"
    )

    var locationDetails by remember { mutableStateOf("") }
    var foodText by remember { mutableStateOf("") }
    var dateText by remember { mutableStateOf("") }
    var timeText by remember { mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    val isSubmitEnabled by remember {
        derivedStateOf {
            selectedCounty.isNotBlank() &&
                    locationDetails.isNotBlank() &&
                    foodText.isNotBlank() &&
                    dateText.isNotBlank() &&
                    timeText.isNotBlank() &&
                    contactNumber.isNotBlank()

        }
    }
        var donationSuccessful by remember { mutableStateOf(false) }

        val icon = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown

         Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = "bg",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
       ) {

        HeadingTextComponent(value = stringResource(id = R.string.DonateWelcome))

        Spacer(modifier = Modifier.height(12.dp))
        Column(

            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = selectedCounty,
                onValueChange = { /* Disable direct text input */ },
                readOnly = true, // Disable direct text input
                label = { Text("Select County") },
                trailingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Dropdown Icon",
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Transparent, // Hide cursor
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textfieldSize = coordinates.size.toSize()
                    }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
            ) {
                counties.forEach { county ->
                    DropdownMenuItem(text = county, onClick = {
                        selectedCounty = county
                        expanded = false
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Pickup Location Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = locationDetails,
                onValueChange = { locationDetails = it },
                label = { Text("Eg Migosi Area, Kenya Re Estate") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Enter Food Item(s)",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = foodText,
                onValueChange = { foodText = it },
                label = { Text("Food Item(s)") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Preferred pickup Date",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = dateText,
                onValueChange = { newText ->
                    if (newText.length <= 10) {
                        val formattedText = newText.take(10).replace(Regex("[^\\d/]"), "")
                        if (formattedText.length == 2 || formattedText.length == 5) {
                            if (newText.length > dateText.length) {
                                dateText = "$formattedText/"
                            } else {
                                dateText = formattedText.dropLast(1)
                            }
                        } else {
                            dateText = formattedText
                        }
                    }
                },
                label = { Text("Day/Month/Year") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number), // Set keyboard type to Number
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                ),
                interactionSource = interactionSource,
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                    }
                ),
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Preferred Time",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = timeText,
                onValueChange = { timeText = it },
                label = { Text("Between 12 noon and 3pm") },
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Contact Number",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = contactNumber,
                onValueChange = { newValue ->
                    if (newValue.length <= 9 && newValue.matches(Regex("\\d*"))) {
                        contactNumber = newValue
                    }
                },
                label = { Text("+254") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )


            Spacer(modifier = Modifier.height(16.dp))

            ButtonComponent(
                value = stringResource(id = R.string.donationsubmitted),
                onButtonClicked = {
                    if (isSubmitEnabled) {
                        donateViewModel.submitDonation(
                            locationDetails,
                            dateText,
                            timeText,
                            contactNumber,
                            foodText,
                            selectedCounty
                        )
                        donationSuccessful = true

                        // Reset input fields
                        selectedCounty = ""
                        locationDetails = ""
                        foodText = ""
                        dateText = ""
                        timeText = ""
                        contactNumber = ""
                    }
                },
                isEnabled = isSubmitEnabled
            )

            if (donationSuccessful) {
                ShowSuccessMessage()
            }
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }

}



@Composable
fun DropdownMenuItem(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun ShowSuccessMessage(){
    Text(
        text = "Donation Successfully Submitted",
        color = Color.Green,
        modifier = Modifier.padding(8.dp),
    )
}

@Preview
@Composable
fun DonateScreenPreview() {
    DonateScreen()
}
