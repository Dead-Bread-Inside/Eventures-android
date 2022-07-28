package eu.deadbread.eventures.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.model.LatLng

class MapScreenViewModel(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
) : ViewModel() {

    /** Contains the last device location. Initial device location is Vilnius */
    var deviceLocation by mutableStateOf(LatLng(54.6966124, 25.2620107))
        private set

    /** Requests device location via FusedLocationProviderClient and puts result into deviceLocation */
    @SuppressLint("MissingPermission")
    fun requestDeviceLocation() {
        val request = CurrentLocationRequest.Builder().build()
        fusedLocationProviderClient.getCurrentLocation(request, null).addOnSuccessListener {
            deviceLocation = LatLng(it.latitude, it.longitude)
        }
    }

}