package eu.deadbread.eventures.ui.map.common

import android.content.Context
import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

data class MapMarkerIcon(val bitmap: Bitmap) {

    class Builder(private val context: Context) {

        fun build(source: MapMarkerSource): MapMarkerIcon? = when (source) {
            is MapMarkerSource.Resource -> buildResource(source.resource)
        }

        private fun buildResource(@DrawableRes resource: Int): MapMarkerIcon? {
            return MapMarkerIcon(ContextCompat.getDrawable(context, resource)?.toBitmap() ?: return null)
        }
    }
}

fun MapMarkerIcon.getBitmapDescriptor(): BitmapDescriptor {
    return BitmapDescriptorFactory.fromBitmap(bitmap)
}