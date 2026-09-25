package ir.polaris.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ir.polaris.test.ui.screens.MainPortfolioScreen
import ir.polaris.test.ui.theme.PolarisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolarisTheme {
                MainPortfolioScreen()
            }
        }
    }
}
