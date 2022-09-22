package com.example.composeex2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)*/

private val DarkColorPalette = darkColors(
    surface = Color.Black,
    onSurface = Color.Green,
    primary = Purple700,
    onPrimary = Color.White

)




private val LightColorPalette = lightColors(
    surface = LightBlue,
    onSurface = Color.White,
    primary = ButtonSky,
    onPrimary = Navy
)

@Composable
fun ComposeEx2Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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