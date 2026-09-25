package ir.polaris.test.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.model.TeamMember
import ir.polaris.test.ui.theme.PolarisBorder
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextMuted
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MemberDetailDialog(
    member: TeamMember,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

    BasicAlertDialog(
        onDismissRequest = onDismiss,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFF2C2E38), RoundedCornerShape(12.dp))
            .background(Color(0xFF101217))
            .testTag("member_detail_dialog")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Top bar with close button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "عضو شماره ${member.number}",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = PolarisGold
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
                                text = "نماینده گروه",
                                fontSize = 10.sp,
                                color = PolarisGoldBright,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

                IconButton(
                    onClick = onDismiss,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "بستن",
                        tint = PolarisTextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Member Photo from website
            if (member.photoRes != null) {
                Image(
                    painter = painterResource(id = member.photoRes),
                    contentDescription = member.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color(0xFF2C2E38), RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.height(14.dp))
            }

            // Member Header
            Text(
                text = member.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = PolarisTextPrimary
            )
            Text(
                text = "${member.englishName} • ${member.role}",
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = PolarisGold,
                modifier = Modifier.padding(top = 2.dp, bottom = 12.dp)
            )

            // Bio
            Text(
                text = "درباره عضو:",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = PolarisGold
            )
            Text(
                text = member.bio,
                fontSize = 13.sp,
                lineHeight = 22.sp,
                color = PolarisTextSecondary,
                modifier = Modifier.padding(top = 4.dp, bottom = 14.dp)
            )

            // Skills & Tech
            Text(
                text = "تکنولوژی‌ها و ابزارها:",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = PolarisGold
            )
            Spacer(modifier = Modifier.height(6.dp))
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                member.technologies.forEach { tech ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .border(0.8.dp, Color(0xFF2E323D), RoundedCornerShape(4.dp))
                            .background(Color(0xFF161820))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = tech,
                            fontSize = 11.sp,
                            color = PolarisTextPrimary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Projects in Assessment
            Text(
                text = "پروژه‌های در دست اقدام:",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = PolarisGold
            )
            Spacer(modifier = Modifier.height(6.dp))
            member.projects.forEach { proj ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 3.dp)
                ) {
                    Text(
                        text = "•",
                        color = PolarisGold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = proj,
                        fontSize = 12.5.sp,
                        color = PolarisTextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Social & Contact Channels
            Text(
                text = "ارتباط با عضو:",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = PolarisGold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf(
                    "GitHub" to (member.github ?: "https://github.com/polaris-test"),
                    "LinkedIn" to (member.linkedin ?: "https://linkedin.com"),
                    "Telegram" to (member.telegram ?: "https://t.me")
                ).forEach { (platform, link) ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .border(0.8.dp, Color(0xFF2C2E38), RoundedCornerShape(6.dp))
                            .background(Color(0xFF14161C))
                            .clickable {
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                val clip = ClipData.newPlainText(platform, link)
                                clipboard.setPrimaryClip(clip)
                                Toast.makeText(context, "$platform: لینک کپی شد", Toast.LENGTH_SHORT).show()
                            }
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = platform,
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Medium,
                            color = PolarisGoldBright
                        )
                    }
                }
            }
        }
    }
}
