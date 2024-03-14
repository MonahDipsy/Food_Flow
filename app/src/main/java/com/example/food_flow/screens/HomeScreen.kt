package com.example.food_flow.screens


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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


    Column {

        CardBorder()

        Row {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            ) {
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.DonateScreen)
                        },
                    painter = painterResource(id = R.drawable.foodbank_icon),
                    contentDescription = "DonateFood",
                    title = "   Make Donation   "
                )
            }

            Spacer(modifier = Modifier.width(3.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.DonateScreen)
                        },
                    painter = painterResource(id = R.drawable.foodbank_icon),
                    contentDescription = "RequestFood",
                    title = "Donation Request "
                )
            }
        }

        Row {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            ) {
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.DonateScreen)
                        },
                    painter = painterResource(id = R.drawable.foodbank_icon),
                    contentDescription = "DonateFood",
                    title = "  Food Bank Admin"
                )
            }

            Spacer(modifier = Modifier.width(3.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                ImageCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            Food_FlowAppRouter.navigateTo(Screen.DonateScreen)
                        },
                    painter = painterResource(id = R.drawable.foodbank_icon),
                    contentDescription = "RequestFood",
                    title = " View Food Banks "
                )
            }
        }

    }
}
@Composable
fun CardBorder(signupViewModel: SignupViewModel = viewModel()) {
    val firstName = signupViewModel.registrationUIState.value.firstName

    Text(
        text = "Home Screen",
        fontSize =  40.sp,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    )
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
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(2f),
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    modifier = Modifier.wrapContentSize(),
                )
                {

                    Text(
                        text = "Hello Monicah Odipo, ", /*$firstName*/
                        fontSize =  18.sp,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(text = "Donation Rating")

                Spacer(modifier = Modifier.height(2.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "4.0",
                        fontSize =  14.sp,
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
                        fontSize =  11.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 150.dp, height = 150.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }
        }
    }
}