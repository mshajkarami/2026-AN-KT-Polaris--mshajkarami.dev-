package ir.polaris.test.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.model.TeamMember
import ir.polaris.test.ui.theme.PolarisBorder
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextMuted
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

/**
 * Recreates the exact Member Card from the reference image:
 * - Number badge (01, 02, etc.)
 * - Ghost watermark typography in background
 * - Cinematic dark portrait silhouette
 * - Persian name and English role
 * - Persian description
 * - Outlined tech badges at bottom
 */
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MemberCard(
    member: TeamMember,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFF23252D), RoundedCornerShape(8.dp))
            .background(Color(0xFF0F1014))
            .clickable { onClick() }
            .testTag("member_card_${member.number}")
    ) {
        // Background Portrait / Moody Cinematic Canvas Art
        MemberCardArtwork(
            memberNumber = member.number,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        // Subtle gradient overlay for readability of text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xCC0F1014),
                            Color(0xFF0F1014)
                        ),
                        startY = 60f
                    )
                )
        )

        // Top Numbers row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Watermark ghost number
            Text(
                text = member.number.trimStart('0'),
                fontFamily = FontFamily.Serif,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0x40FFFFFF)
            )

            // Number in gold
            Text(
                text = member.number,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = PolarisGold
            )
        }

        // Main content column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp)
        ) {
            Spacer(modifier = Modifier.height(130.dp))

            // Ghost watermark English name & role
            Text(
                text = "${member.englishName} • ${member.role.uppercase()}",
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.2.sp,
                color = Color(0x35FFFFFF),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Persian Name & Representative indicator
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = member.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = PolarisTextPrimary
                )
                if (member.isRepresentative) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF282215))
                            .border(0.6.dp, PolarisGold, RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = "نماینده",
                            fontSize = 9.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = PolarisGoldBright
                        )
                    }
                }
            }

            // English Role
            Text(
                text = member.role,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Medium,
                color = PolarisGold,
                modifier = Modifier.padding(top = 2.dp, bottom = 8.dp)
            )

            // Persian Description
            Text(
                text = member.bio,
                fontSize = 12.sp,
                lineHeight = 20.sp,
                color = PolarisTextSecondary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(bottom = 14.dp)
            )

            // Skills & Tech Badges at bottom (like reference image)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                member.technologies.take(3).forEach { tech ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .border(0.8.dp, Color(0xFF2F323B), RoundedCornerShape(4.dp))
                            .background(Color(0xFF14161C))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = tech,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFFC5C8D4)
                        )
                    }
                }
            }
        }
    }
}

/**
 * Procedural moody monochrome dark silhouette portrait
 * perfectly matching the reference image's dark aesthetic without external asset dependencies.
 */
@Composable
private fun MemberCardArtwork(
    memberNumber: String,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height
        val centerX = width * 0.5f

        // Ambient dark backdrop
        drawRect(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFF1F222B),
                    Color(0xFF131418),
                    Color(0xFF0C0D10)
                ),
                center = Offset(centerX, height * 0.4f),
                radius = height * 0.8f
            )
        )

        // Head silhouette
        val headRadius = height * 0.22f
        val headCenter = Offset(centerX, height * 0.34f)

        // Head glow / rim light
        drawCircle(
            color = Color(0x22FFFFFF),
            radius = headRadius + 3f,
            center = headCenter
        )

        drawCircle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF32353E),
                    Color(0xFF1E2026),
                    Color(0xFF101115)
                ),
                start = Offset(headCenter.x - headRadius, headCenter.y - headRadius),
                end = Offset(headCenter.x + headRadius, headCenter.y + headRadius)
            ),
            radius = headRadius,
            center = headCenter
        )

        // Hair / glasses / stylized features depending on member number
        when (memberNumber) {
            "01", "03", "05" -> {
                // Short curly/styled dark hair volume
                drawCircle(
                    color = Color(0xFF262830),
                    radius = headRadius * 0.85f,
                    center = Offset(headCenter.x, headCenter.y - headRadius * 0.45f)
                )
            }
            "02", "04" -> {
                // Flowing longer hair silhouette
                val hairPath = Path().apply {
                    moveTo(headCenter.x - headRadius * 1.1f, headCenter.y)
                    quadraticTo(headCenter.x - headRadius * 1.3f, height * 0.7f, headCenter.x - headRadius * 0.8f, height)
                    lineTo(headCenter.x + headRadius * 0.8f, height)
                    quadraticTo(headCenter.x + headRadius * 1.3f, height * 0.7f, headCenter.x + headRadius * 1.1f, headCenter.y)
                    close()
                }
                drawPath(path = hairPath, color = Color(0xFF16181E))
            }
        }

        // Shoulders / Torso silhouette
        val shoulderPath = Path().apply {
            moveTo(centerX - width * 0.38f, height)
            quadraticTo(centerX - width * 0.25f, height * 0.58f, centerX - headRadius * 0.8f, height * 0.55f)
            lineTo(centerX + headRadius * 0.8f, height * 0.55f)
            quadraticTo(centerX + width * 0.25f, height * 0.58f, centerX + width * 0.38f, height)
            close()
        }

        drawPath(
            path = shoulderPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF22242B),
                    Color(0xFF121316)
                ),
                startY = height * 0.55f,
                endY = height
            )
        )

        // Rim highlight on shoulder
        drawLine(
            color = Color(0x33D8B468),
            start = Offset(centerX - width * 0.28f, height * 0.75f),
            end = Offset(centerX - headRadius * 0.7f, height * 0.58f),
            strokeWidth = 1.2f
        )
    }
}
