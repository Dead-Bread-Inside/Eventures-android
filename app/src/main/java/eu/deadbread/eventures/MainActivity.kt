package eu.deadbread.eventures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.location.LocationServices
import eu.deadbread.eventures.repository.EventsRepository
import eu.deadbread.eventures.ui.screen.MapScreen
import eu.deadbread.eventures.ui.theme.EventuresTheme
import eu.deadbread.eventures.viewmodel.MapScreenViewModel

class MainActivity : ComponentActivity() {
    init {
        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            throw e
        }
    }

    private val mapScreenViewModel by lazy {
        MapScreenViewModel(LocationServices.getFusedLocationProviderClient(this), EventsRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { EventuresTheme { MapScreen(mapScreenViewModel) } }
    }
}