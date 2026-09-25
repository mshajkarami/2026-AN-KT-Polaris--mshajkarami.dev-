package ir.polaris.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextMuted
import ir.polaris.test.ui.theme.PolarisTextPrimary

@Composable
fun PolarisFooter(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF060608))
            .padding(horizontal = 20.dp, vertical = 24.dp)
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Divider line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.8.dp)
                .background(Color(0xFF1B1C22))
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Brand logo
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "POLARIS",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                letterSpacing = 2.5.sp,
                color = PolarisTextPrimary
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "✦",
                color = PolarisGoldBright,
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Motto from reference image
        Text(
            text = "CODE • PEOPLE • A BRIGHTER TOMORROW",
            fontFamily = FontFamily.Monospace,
            fontSize = 9.5.sp,
            letterSpacing = 1.2.sp,
            color = PolarisGold
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Copyright from reference image
        Text(
            text = "POLARIS 2026 © • TEAM TEST",
            fontSize = 11.sp,
            color = PolarisTextMuted
        )
    }
}
