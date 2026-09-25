package ir.polaris.test.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun TeamRepresentativeCard(
    modifier: Modifier = Modifier
) {
    val rep = TeamData.teamMembers.firstOrNull { it.isRepresentative }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFF2F291E), RoundedCornerShape(10.dp))
            .background(Color(0xFF121110))
            .padding(20.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (rep?.photoRes != null) {
                    Image(
                        painter = painterResource(id = rep.photoRes),
                        contentDescription = rep.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(46.dp)
                            .clip(CircleShape)
                            .border(1.5.dp, PolarisGold, CircleShape)
                    )
                } else {
                    // Golden star badge
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF262015))
                            .border(1.dp, PolarisGold, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "✦",
                            color = PolarisGoldBright,
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = rep?.name ?: TeamData.REPRESENTATIVE_TITLE,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = PolarisTextPrimary
                    )
                    Text(
                        text = "${TeamData.REPRESENTATIVE_TITLE} • ${rep?.role ?: TeamData.REPRESENTATIVE_ROLE}",
                        fontSize = 11.5.sp,
                        color = PolarisGold,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Placeholder name for assessment
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1B1A18))
                    .border(0.6.dp, Color(0xFF383124), RoundedCornerShape(6.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = TeamData.REPRESENTATIVE_NAME,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = PolarisGoldBright
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = TeamData.REPRESENTATIVE_DESCRIPTION,
                fontSize = 13.sp,
                lineHeight = 22.sp,
                color = PolarisTextSecondary
            )
        }
    }
}
