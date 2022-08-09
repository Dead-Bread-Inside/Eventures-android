package eu.deadbread.eventures.ui.map.common

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

data class MapMarker(
    val location: MapLocation,
    val title: String? = null,
    val snippet: String? = null,
    val icon: MapMarkerIcon? = null
)

@Composable
@SuppressLint("ComposableNaming")
fun MapMarker.addMarkerToGoogleMaps() = Marker(
    state = MarkerState(position = LatLng(location.latitude, location.longitude)),
    title = title,
    snippet = snippet,
    icon = icon?.getBitmapDescriptor()
)
