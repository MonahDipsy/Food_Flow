package com.example.food_flow.screens

import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.food_flow.R
import com.example.food_flow.navigation.Food_FlowAppRouter
import com.example.food_flow.navigation.Screen
import com.example.food_flow.navigation.SystemBackButtonHandler
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen3() {
    val kenyaFoodBank = LatLng(-1.283333, 36.816667) // Approximate location (Nairobi)
    val kakumaRefugeeCamp = LatLng(-0.07287137195314715,  34.73134512795587)
    val Maseno = LatLng(-0.0018689764189716261, 34.61234376560576)

    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(kenyaFoodBank, 6f) // Adjust zoom level for both locations
    }

    Box(Modifier.fillMaxSize()) {
        GoogleMap(cameraPositionState = cameraPositionState) {
            Marker(
                state = MarkerState(position = kenyaFoodBank),
                title = "Kenya Food Bank",
                icon = mapMarkerIcon(context = LocalContext.current, iconResourceId = R.drawable.kenyabank1)
            )
            Marker(
                state = MarkerState(position = kakumaRefugeeCamp),
                title = "Emmanuel Home for Orphans",
                icon = mapMarkerIcon(context = LocalContext.current, iconResourceId = R.drawable.emmanuel)
            )
            Marker(
                state = MarkerState(position = Maseno),
                title = "Your Location",
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
            )


            Polyline(
                points = listOf(kenyaFoodBank, kakumaRefugeeCamp),
                color = Color.Magenta,
                width = 10f
            )
        }
    }

    SystemBackButtonHandler {
        Food_FlowAppRouter.navigateTo(Screen.MappedDonationsScreen)
    }
}

