@file:OptIn(ExperimentalPermissionsApi::class, ExperimentalPermissionsApi::class, ExperimentalPermissionsApi::class)

package eu.deadbread.eventures.ui.map

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState
import eu.deadbread.eventures.viewmodel.MapScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun GoogleMaps(mapScreenViewModel: MapScreenViewModel) = GoogleMapsCoarseLocationPermission {
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

    }
}

@Composable
fun GoogleMapsCoarseLocationPermission(onPermissionGranted: @Composable () -> Unit) {
    val locationPermission = rememberMultiplePermissionsState(
        listOf(android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION)
    )

    if (locationPermission.allPermissionsGranted) {
        onPermissionGranted()
    } else {
        GoogleMapsLocationPermissionDenied(locationPermission)
    }
}

@Composable
fun GoogleMapsLocationPermissionDenied(locationPermissions: MultiplePermissionsState) = Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Text(
        if (locationPermissions.shouldShowRationale) {
            // If the user has denied the permission but the rationale can be shown,
            // then gently explain why the app requires this permission
            "Need Maps"
        } else {
            // If user doesn't want to be asked again for this permission,
            // explain that the permission is required
            "NEED MAPS!!!"
        }
    )

    // should we show rationale before permission request?
    Button(onClick = { locationPermissions.launchMultiplePermissionRequest() }) {
        Text("Request location permissions")
    }
}