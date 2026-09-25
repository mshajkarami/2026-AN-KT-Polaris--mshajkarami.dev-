package ir.polaris.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.ui.theme.PolarisBackground
import ir.polaris.test.ui.theme.PolarisBorder
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextMuted
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@Composable
fun PolarisHeader(
    selectedSection: String,
    onSectionClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val navItems = listOf(
        "خانه" to "hero",
        "تیم" to "team",
        "مهارت‌ها" to "skills",
        "پروژه‌ها" to "projects",
        "تقسیم وظایف" to "responsibilities",
        "فرآیند همکاری" to "process",
        "درباره ما" to "about",
        "تماس" to "contact"
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(PolarisBackground)
            .statusBarsPadding()
    ) {
        // Main App Bar matching the top bar of the reference image
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // "اعضای تیم" button matching the top-left button in reference image
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(1.dp, Color(0xFF33353D), RoundedCornerShape(6.dp))
                    .background(Color(0xFF0F1014))
                    .clickable { onSectionClick("team") }
                    .padding(horizontal = 14.dp, vertical = 7.dp)
                    .testTag("nav_team_members_button"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "اعضای تیم",
                    color = PolarisTextPrimary,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Brand Logo: POLARIS ✦
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { onSectionClick("hero") }
                    .testTag("brand_logo")
            ) {
                Text(
                    text = "POLARIS",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    letterSpacing = 2.5.sp,
                    color = PolarisTextPrimary
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "✦",
                    color = PolarisGoldBright,
                    fontSize = 14.sp
                )
            }
        }

        // Horizontal navigation tabs row
        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
                .padding(horizontal = 16.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            navItems.forEach { (label, sectionKey) ->
                val isSelected = selectedSection == sectionKey
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(if (isSelected) Color(0xFF1E2028) else Color.Transparent)
                        .border(
                            width = if (isSelected) 1.dp else 0.5.dp,
                            color = if (isSelected) PolarisGold else Color(0xFF20222A),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable { onSectionClick(sectionKey) }
                        .padding(horizontal = 12.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = label,
                        color = if (isSelected) PolarisGold else PolarisTextSecondary,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal
                    )
                }
            }
        }

        // Fine divider line under header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.6.dp)
                .background(Color(0xFF1C1D24))
        )
    }
}
