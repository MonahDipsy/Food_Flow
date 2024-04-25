package com.example.food_flow.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_flow.R
import com.example.food_flow.components.HeadingTextComponent
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun MappedDonationsScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg1),
            contentDescription = "bg",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeadingTextComponent(value = stringResource(id = R.string.map))
            DonationCard(
                title = "DONATION3: Kakuma Refugee Camp",
                inWarehouseColor = Color.White,
                inTransitColor = Color.Red,
                deliveredColor = Color.Green,
                onClick = { Food_FlowAppRouter.navigateTo(Screen.ViewInMapScreen) } // Click action for Donation3
            )

            DonationCard(
                title = "DONATION4: Daadab Refugee Camp",
                inWarehouseColor = Color.White,
                inTransitColor = Color.Red,
                deliveredColor = Color.Green,
                onClick = { Food_FlowAppRouter.navigateTo(Screen.MapScreen2) } // Click action for Donation4
            )

            DonationCard(
                title = "DONATION5: Emmanuel Home for Orphans",
                inWarehouseColor = Color.White,
                inTransitColor = Color.Red,
                deliveredColor = Color.Green,
                onClick = { Food_FlowAppRouter.navigateTo(Screen.MapScreen3) } // Click action for Donation5
            )
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.DonationsSubmittedScreen)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DonationCard(
    inWarehouseColor: Color,
    inTransitColor: Color,
    deliveredColor: Color,
    title: String,
    onClick: () -> Unit // Function to handle button click
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Transparent),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleShape(color = inWarehouseColor)
                Spacer(modifier = Modifier.width(18.dp))
                Text(
                    text = "In Warehouse",
                )
                Text(
                    text = "\u2713", // Unicode for tick mark
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleShape(color = inTransitColor)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "In Transit",
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleShape(color = deliveredColor)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Delivered",
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = onClick, // Button click action
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                contentPadding = PaddingValues(vertical = 8.dp) // Add some padding to button content
            ) {
                Text(text = "View in Map")
            }
        }
    }
}


@Composable
fun CircleShape(color: Color) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(color)
    )
}
