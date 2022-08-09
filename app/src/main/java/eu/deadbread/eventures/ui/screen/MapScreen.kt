package eu.deadbread.eventures.ui.screen

import android.Manifest
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import eu.deadbread.eventures.R
import eu.deadbread.eventures.ui.map.common.MapMarker
import eu.deadbread.eventures.ui.map.common.MapMarkerIcon
import eu.deadbread.eventures.ui.map.common.MapMarkerSource
import eu.deadbread.eventures.ui.map.common.addMarkerToGoogleMaps
import eu.deadbread.eventures.ui.map.google.GoogleMaps
import eu.deadbread.eventures.viewmodel.MapScreenViewModel

@SuppressLint("MissingPermission")
@Composable
fun MapScreen(mapScreenViewModel: MapScreenViewModel) = Scaffold(
    floatingActionButton = {
        FloatingActionButton(onClick = { mapScreenViewModel.requestDeviceLocation() }) {}
    }
) {
    MapsScreenLocationPermission {
        GoogleMaps(mapScreenViewModel) {
            val source = MapMarkerSource.Resource(R.drawable.ic_map_marker_debug)

            mapScreenViewModel.eventsInArea.map { event ->
                MapMarker(
                    location = event.info.location,
                    title = event.info.title,
                    snippet = event.info.description,
                    icon = MapMarkerIcon.Builder(LocalContext.current).build(source)
                )
            }.forEach { it.addMarkerToGoogleMaps() }
        }
    }
}

@Composable
fun MapsScreenLocationPermission(onPermissionGranted: @Composable () -> Unit) {
    val locationPermission = rememberMultiplePermissionsState(
        listOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
    )

    if (locationPermission.allPermissionsGranted) {
        onPermissionGranted()
    } else {
        MapsScreenLocationPermissionDenied(locationPermission)
    }
}

@Composable
fun MapsScreenLocationPermissionDenied(locationPermissions: MultiplePermissionsState) = Column(
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
