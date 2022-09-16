package eu.deadbread.eventures.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import eu.deadbread.eventures.ui.theme.ETheme.isInDarkTheme

object ETheme {

    internal val LocalCompositionIsInDarkTheme = staticCompositionLocalOf { false }
    val isInDarkTheme: Boolean
        @Composable get() = LocalCompositionIsInDarkTheme.current

    internal val LocalCompositionMaterialColors = staticCompositionLocalOf { LightMaterialColorScheme }
    val materialColors: ColorScheme
        @Composable get() = LocalCompositionMaterialColors.current

    internal val LocalCompositionColors = staticCompositionLocalOf { LightColorScheme }
    val colors: EColorScheme
        @Composable get() = LocalCompositionColors.current
}

@Composable
fun EventuresTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) = CompositionLocalProvider(ETheme.LocalCompositionIsInDarkTheme provides darkTheme) {
    CompositionLocalProvider(
        ETheme.LocalCompositionMaterialColors provides if (isInDarkTheme) DarkMaterialColorScheme else LightMaterialColorScheme,
        ETheme.LocalCompositionColors provides if (isInDarkTheme) DarkColorScheme else LightColorScheme,
    ) {
        EventuresTheme(content)
    }
}

@Composable
private fun EventuresTheme(content: @Composable () -> Unit) {
    val colors = ETheme.materialColors
    val darkTheme = isInDarkTheme
    val view = LocalView.current
    if (!view.isInEditMode) SideEffect {
        (view.context as Activity).window.statusBarColor = colors.primary.toArgb()
        ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
    }


    MaterialTheme(
        colorScheme = ETheme.materialColors,
        typography = ETypography.MaterialTypography,
        content = content
    )
}