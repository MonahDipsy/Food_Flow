package com.example.food_flow.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.R
import com.example.food_flow.app.data.homescreen.ReceiveViewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_flow.components.HeadingTextComponent
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun RejectDonationsScreen() {
    val context = LocalContext.current
    val auth = Firebase.auth
    val currentUser = auth.currentUser

    val senderEmail = remember { mutableStateOf(currentUser?.email ?: "") }
    val emailSubject = remember { mutableStateOf(TextFieldValue("YOUR DONATION HAS BEEN REJECTED")) }
    val emailBody = remember { mutableStateOf(TextFieldValue(
        "Dear Donor,\n\n" +
                "Thank you for your recent donation. After careful review, we regret to inform you that we are unable to accept your donation at this time.\n\n" +
                "We appreciate your willingness to support our cause and your generosity is commendable. However, due to certain constraints or criteria, we are unable to accommodate your donation at this moment.\n\n" +
                "We value your continued support and hope for your understanding in this matter.\n\n" +
                "Regards,\nKenya Food Bank"
    )) }

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = "bg",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HeadingTextComponent(value = stringResource(id = R.string.confirmrejection))

            TextField(
                value = TextFieldValue(senderEmail.value), // Use the retrieved sender email
                onValueChange = {}, // Prevent editing
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                enabled = false,
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = emailSubject.value,
                onValueChange = {}, // Prevent editing
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                enabled = false, // Make read-only
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )

            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = emailBody.value,
                onValueChange = {}, // Prevent editing
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                enabled = false,
                colors = OutlinedTextFieldDefaults.colors(
                    cursorColor = Color.Black,
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Blue,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    val email = senderEmail.value
                    val subject = emailSubject.value.text
                    val body = emailBody.value.text

                    val i = Intent(Intent.ACTION_SEND)
                    val emailAddress = arrayOf(email)
                    i.putExtra(Intent.EXTRA_EMAIL, emailAddress)
                    i.putExtra(Intent.EXTRA_SUBJECT, subject)
                    i.putExtra(Intent.EXTRA_TEXT, body)
                    i.setType("message/rfc822")
                    context.startActivity(Intent.createChooser(i, "Choose an Email client : "))
                },
                modifier = Modifier.padding(10.dp),
            ) {
                Text(
                    text = "Send Email Approval",
                    modifier = Modifier.padding(10.dp),
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.DonationsSubmittedScreen)
    }
}
