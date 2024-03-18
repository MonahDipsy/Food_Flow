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
import androidx.compose.ui.res.stringResource
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
import com.example.food_flow.components.CardBorder
import com.example.food_flow.components.ImageCard
import com.example.food_flow.components.NormalTextComponent


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



    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
    ){

        CardBorder()

        Spacer(modifier = Modifier.width(5.dp))

        Spacer(modifier = Modifier.height(3.dp))


        OutlinedButton(
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.White
            ),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "You have made 1 approved donations",
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleLarge
            )
        }
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


