package com.example.financepal.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1E88E5), // Plava boja za primarne elemente
    onPrimary = Color.Black,
    secondary = Color(0xFF1E88E5),
    background = Color(0xFF303030), // Tamna pozadina
    onBackground = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1E88E5), // Plava boja za primarne elemente
    onPrimary = Color.White,
    secondary = Color(0xFF1E88E5),
    background = Color(0xFFBBDEFB), // Svijetlo plava pozadina
    onBackground = Color.Black

    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onSurface = Color.Black,
    */
)

@Composable
fun FinancePalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
