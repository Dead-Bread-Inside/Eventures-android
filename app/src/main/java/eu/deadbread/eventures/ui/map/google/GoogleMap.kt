package eu.deadbread.eventures.ui.map.google

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import eu.deadbread.eventures.viewmodel.MapScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun GoogleMaps(mapScreenViewModel: MapScreenViewModel, mapsScope: @Composable () -> Unit) {
    val coroutineScope = rememberCoroutineScope()

    val mapUiSettings = MapUiSettings(myLocationButtonEnabled = true)
    val mapProperties = MapProperties(isMyLocationEnabled = true)

    val cameraPositionState = rememberCameraPositionState()

    LaunchedEffect(mapScreenViewModel.deviceLocation) {
        coroutineScope.launch {
            cameraPositionState.animate(CameraUpdateFactory.newLatLngZoom(mapScreenViewModel.deviceLocation, 16f), 1000)
        }
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        uiSettings = mapUiSettings,
        properties = mapProperties,
        cameraPositionState = cameraPositionState,
    ) {
        mapsScope()
    }
}
