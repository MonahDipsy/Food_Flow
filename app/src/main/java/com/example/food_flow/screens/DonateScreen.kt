package com.example.food_flow.screens

import DonateViewModel
import DonateViewModelFactory
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DonateScreen() {

    val donateViewModel: DonateViewModel = viewModel(factory = DonateViewModelFactory(FirebaseAuth.getInstance().currentUser?.email ?: ""))


    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }

    var donationSuccessful by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    LaunchedEffect(donationSuccessful) {
        if (donationSuccessful) {
            showSuccessDialog = true
            delay(8000)
            showSuccessDialog = false
        }
    }



    var selectedCounty by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var foodBankExpanded by remember { mutableStateOf(false) }
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
    val foodBankOptions = listOf("Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya", "Food Banking Kenya")


    var locationDetails by remember { mutableStateOf("") }
    var selectedFoodBank by remember { mutableStateOf("") }
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
                    selectedFoodBank.isNotBlank()&&
                    contactNumber.isNotBlank()

        }
    }
    val foodBankIcon = if (foodBankExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown
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
                    .padding(vertical = 8.dp)
            ) {
                // First lambda expression
                counties.forEach { county ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { // Add clickable modifier to each county
                                selectedCounty = county
                                expanded = false
                            }
                    ) {
                        Text(
                            text = county,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        // Add horizontal line separator except for the last item
                        if (county != counties.last()) {
                            Divider(color = Color.Black, thickness = 1.dp)
                        }
                    }
                }
            } // End of first lambda expression




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

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = selectedFoodBank,
                onValueChange = { /* Disable direct text input */ },
                readOnly = true,
                label = { Text("Select Food Bank") },
                trailingIcon = {
                    Icon(
                        imageVector = foodBankIcon,
                        contentDescription = "Dropdown Icon",
                        modifier = Modifier.clickable { foodBankExpanded = !foodBankExpanded }
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Transparent,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = foodBankExpanded,
                onDismissRequest = { foodBankExpanded = false },
                modifier = Modifier
                    .width(with(LocalDensity.current) { textfieldSize.width.toDp() })
                    .padding(vertical = 8.dp)
            ) {
                // First lambda expression
                foodBankOptions.forEach { foodBank ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { // Add clickable modifier to each county
                                selectedFoodBank = foodBank
                                foodBankExpanded = false
                            }
                    ) {
                        Text(
                            text = foodBank,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        // Add horizontal line separator except for the last item
                        if (foodBank != foodBankOptions.last()) {
                            Divider(color = Color.Black, thickness = 1.dp)
                        }
                    }
                }
            }



            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Preferred pickup Date",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            showDatePicker(context = LocalContext.current) { selectedDate ->
                dateText = selectedDate
            }

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = dateText,
                onValueChange = { },
                readOnly = true, // Prevent typing in the field
                label = { Text("Day/Month/Year") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
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
            ShowTimePicker(LocalContext.current) { selectedTime ->
                timeText = selectedTime
            }

            OutlinedTextField(
                shape = RoundedCornerShape(8.dp),
                value = timeText,
                onValueChange = { },
                readOnly = true, // Prevent typing in the field
                label = { Text("Select pickup time") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number, imeAction = ImeAction.None),
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                ),
                modifier = Modifier.fillMaxWidth()
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
                        val currentUser = FirebaseAuth.getInstance().currentUser
                        val userEmail = currentUser?.email ?: ""
                        donateViewModel.submitDonation(
                            locationDetails,
                            dateText,
                            timeText,
                            contactNumber,
                            foodText,
                            selectedCounty,
                            userEmail,
                            selectedFoodBank
                        )
                        donationSuccessful = true

                        selectedCounty = ""
                        locationDetails = ""
                        foodText = ""
                        dateText = ""
                        timeText = ""
                        contactNumber = ""
                        selectedFoodBank = ""
                    }
                },
                isEnabled = isSubmitEnabled
            )

            if (showSuccessDialog) {
                AlertDialog(
                    onDismissRequest = { showSuccessDialog = false },
                    title = { Text("Submission Successful!") },
                    text = { Text("Your donation has been submitted for review.",
                        color = Color.Green,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(8.dp)) },
                    confirmButton = {
                        Button(onClick = { showSuccessDialog = false }) {
                            Text("OK")
                        }
                    }
                )
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
        text = "Your Donation has been Successfully Submitted for review",
        color = Color.Green,
        modifier = Modifier.padding(8.dp),
    )
}

@Composable
fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val selectedDate = "$dayOfMonth/${month + 1}/$year"
            onDateSelected(selectedDate)
        }, year, month, day
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            datePickerDialog.show()
        }) {
            Text(text = "Select Date")
        }
    }
}
    @Composable
    fun ShowTimePicker(context: Context, onTimeSelected: (String) -> Unit){

        val calendar = Calendar.getInstance()
        val hour = calendar[Calendar.HOUR_OF_DAY]
        val minute = calendar[Calendar.MINUTE]

        val time = remember { mutableStateOf("") }
        val timePickerDialog = TimePickerDialog(
            context,
            {_, hour : Int, minute: Int ->
                val selectedTime = "$hour:$minute"
                onTimeSelected(selectedTime) // Call the callback function with the selected time
                time.value = selectedTime // Update the local state
            }, hour, minute, false
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {

            Button(onClick = {
                timePickerDialog.show()
            }) {
                Text(text = "Select Time")
            }

        }

    }

