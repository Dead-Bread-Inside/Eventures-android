package eu.deadbread.eventures.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap

@Composable
fun GoogleMaps() {
    GoogleMap(modifier = Modifier.fillMaxSize()) {}
}
