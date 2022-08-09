package eu.deadbread.eventures.ui.map.common

import androidx.annotation.DrawableRes

sealed class MapMarkerSource {
    data class Resource(@DrawableRes val resource: Int) : MapMarkerSource()
}