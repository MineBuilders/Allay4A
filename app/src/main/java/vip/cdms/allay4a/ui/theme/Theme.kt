package vip.cdms.allay4a.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightColors = lightColors(
    primary = ColorPrimary,
    primaryVariant = ColorPrimaryVariant,
    secondary = ColorSecondary,
    secondaryVariant = ColorSecondaryVariant,
    onPrimary = ColorOnPrimary,
)

private val darkColors = darkColors(
    primary = ColorPrimary,
    primaryVariant = ColorPrimaryVariant,
    secondary = ColorSecondary,
    secondaryVariant = ColorSecondaryVariant,
    onPrimary = ColorOnPrimary,
)

@Composable
fun Allay4ATheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) darkColors else lightColors,
        content = content
    )
}

@Composable
fun AlwaysDarkTheme(content: @Composable () -> Unit) {
    Allay4ATheme(darkTheme = true, content = content)
}
