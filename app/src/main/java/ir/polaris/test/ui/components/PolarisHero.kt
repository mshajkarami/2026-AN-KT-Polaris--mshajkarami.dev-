package ir.polaris.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.data.TeamData
import ir.polaris.test.ui.theme.PolarisBorder
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextMuted
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@Composable
fun PolarisHero(
    onExploreTeamClick: () -> Unit,
    onProjectsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Celestial Artwork from reference image
        PolarisHeroArt(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        // Eyebrow: POLARIS SOFTWARE DEVELOPMENT COMPANY
        Text(
            text = TeamData.POLARIS_EYEBROW,
            color = PolarisGold,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.8.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 6.dp)
        )

        // Giant Display POLARIS in classic serif
        Text(
            text = "POLARIS",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 46.sp,
            letterSpacing = 4.sp,
            color = PolarisTextPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        // Assessment badge
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF131419))
                .border(0.8.dp, Color(0xFF2C2E38), RoundedCornerShape(20.dp))
                .padding(horizontal = 14.dp, vertical = 5.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "✦",
                    color = PolarisGold,
                    fontSize = 10.sp
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "فرآیند ارزیابی استخدامی • گروه Test",
                    color = PolarisGoldBright,
                    fontSize = 11.5.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Hero Title in Persian
        Text(
            text = TeamData.HERO_TITLE,
            color = PolarisTextPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Hero Description in Persian
        Text(
            text = TeamData.HERO_DESCRIPTION,
            color = PolarisTextSecondary,
            fontSize = 13.5.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp, end = 4.dp, bottom = 24.dp)
        )

        // Action Buttons Row matching reference design
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Outlined primary action button with arrow (like the reference image)
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(1.dp, Color(0xFF3B3E48), RoundedCornerShape(6.dp))
                    .background(Color(0xFF101217))
                    .clickable { onExploreTeamClick() }
                    .padding(horizontal = 20.dp, vertical = 12.dp)
                    .testTag("hero_team_button"),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "آشنایی با تیم",
                        color = PolarisTextPrimary,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "←",
                        color = PolarisGold,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Secondary button for projects
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .border(1.dp, Color(0xFF22242B), RoundedCornerShape(6.dp))
                    .background(Color(0xFF0C0D10))
                    .clickable { onProjectsClick() }
                    .padding(horizontal = 18.dp, vertical = 12.dp)
                    .testTag("hero_projects_button"),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "پروژه‌ها",
                    color = PolarisTextSecondary,
                    fontSize = 13.5.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
