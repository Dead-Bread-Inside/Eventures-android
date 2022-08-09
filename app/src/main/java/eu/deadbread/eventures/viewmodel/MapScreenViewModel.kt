package eu.deadbread.eventures.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.CurrentLocationRequest
import com.google.android.gms.location.FusedLocationProviderClient
import eu.deadbread.eventures.entities.Distance
import eu.deadbread.eventures.entities.Event
import eu.deadbread.eventures.entities.Location
import eu.deadbread.eventures.repository.EventsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapScreenViewModel(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val eventsRepository: EventsRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            delay(10000)
            eventsInArea = eventsRepository.getEventsInArea(deviceLocation, Distance.Kilometers(5))
        }
    }

    /** Contains the last device location. Initial device location is Vilnius */
    var deviceLocation by mutableStateOf(Location(54.6966124, 25.2620107))
        private set

    /** Requests device location via FusedLocationProviderClient and puts result into deviceLocation */
    @SuppressLint("MissingPermission")
    fun requestDeviceLocation() {
        val request = CurrentLocationRequest.Builder().build()
        fusedLocationProviderClient.getCurrentLocation(request, null).addOnSuccessListener {
            deviceLocation = Location(it.latitude, it.longitude)
        }
    }


    /** Contains list of events in the area nearby */
    var eventsInArea by mutableStateOf<List<Event>>(emptyList())
        private set


}
