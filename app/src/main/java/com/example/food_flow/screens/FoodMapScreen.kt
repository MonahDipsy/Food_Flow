package com.example.food_flow.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler

@Composable
fun FoodMapScreen() {
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Food Banks") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
        )

        // List of Food Banks
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(foodBanks) { foodBank ->
                FoodBankListItem(
                    name = foodBank.name,
                    location = foodBank.location
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun FoodBankListItem(name: String, location: String) {
    val subtitle1 = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    )

    val body1 = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = name,
                style = subtitle1
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = location,
                style = body1
            )
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.HomeScreen)
    }
}

data class FoodBank(val name: String, val location: String)

val foodBanks = listOf(
    FoodBank(
        name = "Life Church International",
        location = "1st Floor, Kenya Cinema Plaza, Moi Ave, Nairobi, Kenya"
    ),
    FoodBank(
        name = "International Christian Center - Nairobi",
        location = "Mombasa Road, Nairobi, Kenya"
    ),
    FoodBank(
        name = "Kenya Evangelical Lutheran Church",
        location = "Off Jogoo Road on Nile Road Jerusalem Estate, Nairobi"
    ),
    FoodBank(
        name = "Rehema Home",
        location = "Nairobi, Kenya"
    ),
    FoodBank(
        name = "Food Banking Kenya",
        location = "Northern By-pass Near Two Rivers Nairobi P.O. Box 966-00517 Nairobi Kenya"
    ),
FoodBank(
name = "International Christian Center - Nairobi",
location = "Mombasa Road, Nairobi, Kenya"
),
FoodBank(
name = "Kenya Evangelical Lutheran Church",
location = "Off Jogoo Road on Nile Road Jerusalem Estate, Nairobi"
),
FoodBank(
name = "Rehema Home",
location = "Nairobi, Kenya"
),
FoodBank(
name = "Food Banking Kenya",
location = "Northern By-pass Near Two Rivers Nairobi P.O. Box 966-00517 Nairobi Kenya"
),
FoodBank(
name = "World Food Programme",
location = "UN Gigiri Compound, Nairobi, Kenya"
),
FoodBank(
name = "Feed The Children",
location = "Near Dagoretti Police Station, Dagoretti Rd, Nairobi, Kenya"
),
FoodBank(
name = "Prophet Reward Foundation",
location = "PO BOX 8864-00100, NAIROBI, KENYA, EAST AFRICA. Nairobi Kenya"
),
FoodBank(
name = "Shelter of hope",
location = "Buru Buru Business Complex, Next To Kenya National Library, 2nd Flr, Rm 32"
),
FoodBank(
name = "Children of Hope",
location = "House No. 149 Golf Course , Mosiro Court, Mosiro Road, Nairobi, Kenya"
)
)


@Preview
@Composable
fun FoodMapPreview(){
    FoodMapScreen()
}