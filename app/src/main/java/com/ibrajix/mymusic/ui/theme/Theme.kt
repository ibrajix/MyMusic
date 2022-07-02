package com.ibrajix.mymusic.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Colors


//custom colors
val Colors.lightGrey : Color get() = LightGrey
val Colors.darkGrey : Color get() = DarkGrey
val Colors.bgHome : Color get() = BgHome

private val DarkColorPalette = darkColors(
    primary = Purple600,
    primaryVariant = Purple600,
    secondary = White,
    onPrimary = White,
    onSecondary = Black
)

private val LightColorPalette = lightColors(
    primary = Purple400,
    primaryVariant = Purple400,
    secondary = White,
    onPrimary = White,
    onSecondary = Black
)

@Composable
fun MyMusicTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}