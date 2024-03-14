package com.example.food_flow.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_flow.R
import com.example.food_flow.app.data.signup.SignupViewModel
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.food_flow.components.ImageCard


@Composable
fun HomeScreen(
) {

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.bg1),
            contentDescription = "bg",
            modifier = Modifier
                .fillMaxSize()
                .blur(6.dp),
            contentScale = ContentScale.Crop

        )
    }

    Column {

        CardBorder()

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            // First Card
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.DonateScreen)
                        },
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp,
                    )
                ) {
                    ImageCard(
                        painter = painterResource(id = R.drawable.five),
                        contentDescription = "DonateFood",
                        title = ""
                    )
                }
            }

            // Spacer
            Spacer(modifier = Modifier.width(3.dp))

            // Second Card
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.ReceiveScreen)
                        },
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp,
                    )
                ) {
                    ImageCard(
                        painter = painterResource(id = R.drawable.reqone),
                        contentDescription = "DonateFood",
                        title = "   "
                    )
                }
            }
        }

        // Spacer
        Spacer(modifier = Modifier.height(3.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            // Third Card
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.FoodBankScreen)
                        },
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp,
                    )
                ) {
                    ImageCard(
                        painter = painterResource(id = R.drawable.bank),
                        contentDescription = "DonateFood",
                        title = ""
                    )
                }
            }

            // Spacer
            Spacer(modifier = Modifier.width(3.dp))

            // Fourth Card
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.FoodMapScreen)
                        },
                    shape = RoundedCornerShape(15.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 5.dp,
                    )
                ) {
                    ImageCard(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "DonateFood",
                        title = ""
                    )
                }
            }
        }
    }


}
@Composable
fun CardBorder(
    signupViewModel: SignupViewModel = viewModel(),


) {
    val firstName = signupViewModel.registrationUIState.value.firstName

    Text(
        text = "Home Screen",
        textAlign = TextAlign.Center,
        fontSize = 40.sp,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    )

    Box(
        modifier = Modifier
            .height(210.dp)
            .padding(10.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.primaryContainer,
            border = BorderStroke(2.dp, Color.Black),
            modifier = Modifier
                .height(210.dp)
                .padding(10.dp),
            shadowElevation = 10.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(2f),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Hello Monicah Odipo, ", /*$firstName*/
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(text = "Donation Rating",    color = Color.Black)

                    Spacer(modifier = Modifier.height(2.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "4.0",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_star_outline_24),
                            tint = Color(0xFFF6B266),
                            contentDescription = null
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_star_outline_24),
                            tint = Color(0xFFF6B266),
                            contentDescription = null
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_star_outline_24),
                            tint = Color(0xFFF6B266),
                            contentDescription = null
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_star_outline_24),
                            tint = Color(0xFFF6B266),
                            contentDescription = null
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    OutlinedButton(
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Black,
                            containerColor = Color.White
                        ),
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Update Details",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
                Surface(
                    shape = CircleShape,
                    modifier = Modifier.size(width = 147.dp, height = 150.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sponge),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                }
            }
        }
    }
}