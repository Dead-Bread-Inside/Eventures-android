@file:OptIn(ExperimentalMaterial3Api::class)

package eu.deadbread.eventures.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import eu.deadbread.eventures.ui.map.GoogleMaps
import eu.deadbread.eventures.viewmodel.MapScreenViewModel

@SuppressLint("MissingPermission")
@Composable
fun MapScreen(mapScreenViewModel: MapScreenViewModel) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { mapScreenViewModel.requestDeviceLocation() }) {}
        }
    ) {
        GoogleMaps(mapScreenViewModel)
    }
}
