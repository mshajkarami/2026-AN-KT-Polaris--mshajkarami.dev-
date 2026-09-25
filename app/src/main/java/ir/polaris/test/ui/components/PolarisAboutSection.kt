package ir.polaris.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.data.TeamData
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@Composable
fun PolarisAboutSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Section 1: About Test Team
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xFF22242C), RoundedCornerShape(10.dp))
                .background(Color(0xFF0F1014))
                .padding(20.dp)
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "✦",
                        color = PolarisGold,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = TeamData.ABOUT_TEST_TITLE,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PolarisTextPrimary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = TeamData.ABOUT_TEST_CONTENT,
                    fontSize = 13.5.sp,
                    lineHeight = 25.sp,
                    color = PolarisTextSecondary
                )
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        // Section 2: About Polaris (recreating the exact section from the reference image)
        Text(
            text = TeamData.ABOUT_POLARIS_EYEBROW,
            color = PolarisGold,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Huge display title matching reference: "ما فقط کد نمی‌زنیم؛ محصول می‌سازیم."
        Text(
            text = TeamData.ABOUT_POLARIS_HEADLINE,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 36.sp,
            color = PolarisTextPrimary,
            modifier = Modifier.padding(bottom = 14.dp)
        )

        // Polaris description
        Text(
            text = TeamData.ABOUT_POLARIS_DESC_1,
            fontSize = 13.5.sp,
            lineHeight = 24.sp,
            color = PolarisTextSecondary,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Text(
            text = TeamData.ABOUT_POLARIS_DESC_2,
            fontSize = 13.sp,
            lineHeight = 23.sp,
            color = Color(0xFF888B96)
        )
    }
}
