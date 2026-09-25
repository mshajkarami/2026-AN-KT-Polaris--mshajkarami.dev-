package ir.polaris.test.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.WindowCompat

private val PolarisDarkColorScheme = darkColorScheme(
    primary = PolarisGold,
    onPrimary = PolarisBackground,
    primaryContainer = PolarisGoldMuted,
    onPrimaryContainer = PolarisGoldBright,
    secondary = PolarisGoldMuted,
    onSecondary = PolarisTextPrimary,
    background = PolarisBackground,
    onBackground = PolarisTextPrimary,
    surface = PolarisSurface,
    onSurface = PolarisTextPrimary,
    surfaceVariant = PolarisSurfaceElevated,
    onSurfaceVariant = PolarisTextSecondary,
    outline = PolarisBorder,
    outlineVariant = PolarisBorderSubtle
)

@Composable
fun PolarisTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = PolarisBackground.toArgb()
                window.navigationBarColor = PolarisBackground.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
                WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = false
            }
        }
    }

    MaterialTheme(
        colorScheme = PolarisDarkColorScheme,
        typography = Typography
    ) {
        ProvideTextStyle(value = TextStyle(fontFamily = IranYekan)) {
            content()
        }
    }
}
