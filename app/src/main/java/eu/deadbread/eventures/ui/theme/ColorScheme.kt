package eu.deadbread.eventures.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkMaterialColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

val LightMaterialColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = White,
    primaryContainer = Blue,

    secondary = White,
    onSecondary = Black,

    background = White,
    onBackground = Black
)

val LightColorScheme = EColorScheme(
    title = "Light color scheme",
    accent = Blue,
    onAccent = Color.White,
    opaque = BlackA30,
    background = Color.White
)

val DarkColorScheme = EColorScheme(
    title = "Dark color scheme",
    accent = Color.Magenta,
    onAccent = Color.White,
    opaque = WhiteA30,
    background = Color.Black,
)

data class EColorScheme(
    internal val title: String,
    val accent: Color,
    val onAccent: Color,
    val opaque: Color,
    val background: Color,
)

val EColorScheme.transparent: Color
    get() = Color.Transparent