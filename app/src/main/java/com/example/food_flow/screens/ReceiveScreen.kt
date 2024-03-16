package com.example.food_flow.screens

import DonateViewModel
import RequestViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.R
import com.example.food_flow.components.ButtonComponent
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.components.RoundedCornerOutlinedTextField
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler



@Composable
fun ReceiveScreen(requestViewModel: RequestViewModel = viewModel()){
    
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


    var requestType by remember { mutableStateOf("") }
    var requestPurpose by remember { mutableStateOf("") }
    var deliveryPreference by remember { mutableStateOf("") }
    var foodPreference by remember { mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero) }
    val isSubmitEnabled by remember {
        derivedStateOf {
            selectedCounty.isNotBlank() &&
                    requestType.isNotBlank() &&
                    requestPurpose.isNotBlank() &&
                    deliveryPreference.isNotBlank() &&
                    foodPreference.isNotBlank() &&
                    contactNumber.isNotBlank()
        }
    }
    var requestSuccessful by remember { mutableStateOf(false) }

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

        HeadingTextComponent(value = stringResource(id = R.string.RequestDonation))

        Spacer(modifier = Modifier.height(12.dp))
        Column(

            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(

                value = selectedCounty,
                onValueChange = { selectedCounty = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        textfieldSize = coordinates.size.toSize()
                    },
                label = { Text("Select County") },
                trailingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Dropdown Icon",
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                }
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
            ) {
                counties.forEach { county ->
                    DropdownMenuItem2(text = county, onClick = {
                        selectedCounty = county
                        expanded = false
                    })
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Type of Request\n1. Individual \n2. Organization/Community",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = requestType,
                onValueChange = { requestType = it },
                label = { Text(text = "Enter 1 or 2")},
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Purpose of Donation Request",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = requestPurpose,
                onValueChange = { requestPurpose = it },
                label = { Text("Specify the reason for the request") },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Delivery Preferences",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = deliveryPreference,
                onValueChange = { deliveryPreference = it },
                label = { Text("Any Special Instructions for Pickup/Delivery") },
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Preferred Food Details",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = foodPreference,
                onValueChange = { foodPreference = it },
                label = { Text("Types of Food Required") },
                modifier = Modifier.fillMaxWidth(),
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
                value = contactNumber,
                onValueChange = { newValue ->
                    // Check if the value consists of only digits and the length is <= 9
                    if (newValue.length <= 9 && newValue.matches(Regex("\\d*"))) {
                        contactNumber = newValue
                    }
                },
                label = { Text("+254") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )


            Spacer(modifier = Modifier.height(16.dp))

            ButtonComponent(
                value = stringResource(id = R.string.submitrequest),
                onButtonClicked = {
                    if (isSubmitEnabled) {
                        requestViewModel.submitRequest(
                            requestType,
                            foodPreference,
                            deliveryPreference,
                            contactNumber,
                            requestPurpose,
                            selectedCounty
                        )
                        requestSuccessful = true

                        // Reset input fields
                        selectedCounty = ""
                        requestType = ""
                        foodPreference = ""
                        deliveryPreference = ""
                        contactNumber = ""
                        requestPurpose = ""
                        selectedCounty = ""
                    }
                },
                isEnabled = isSubmitEnabled
            )

            if (requestSuccessful) {
                ShowSuccessMessage2()
            }
        }
    }


    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }

}



@Composable
fun DropdownMenuItem2(
    text: String,
    onClick: () -> Unit
) {
    Text(
        text = text,
        modifier = Modifier.clickable { onClick() }
    )
}

@Composable
fun ShowSuccessMessage2(){
    Text(
        text = "Donation Request Successfully Submitted!",
        color = Color.Green,
        fontSize = 18.sp,
        modifier = Modifier.padding(8.dp),
    )
}

