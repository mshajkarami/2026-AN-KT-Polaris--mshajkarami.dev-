package ir.polaris.test.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.model.Project
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFF22242D), RoundedCornerShape(8.dp))
            .background(Color(0xFF0F1014))
            .padding(16.dp)
            .testTag("project_card_${project.title.hashCode()}")
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = project.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = PolarisTextPrimary,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Status tag
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF131924))
                        .border(0.6.dp, Color(0xFF253B5A), RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = project.status,
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF93C5FD)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Responsible member
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "مسئول اجرا:",
                    fontSize = 11.5.sp,
                    color = PolarisGold,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = project.responsibleMember,
                    fontSize = 12.sp,
                    color = PolarisGoldBright,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = project.description,
                fontSize = 12.5.sp,
                lineHeight = 21.sp,
                color = PolarisTextSecondary,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Technologies
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                project.technologies.forEach { tech ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .border(0.8.dp, Color(0xFF2C2F39), RoundedCornerShape(4.dp))
                            .background(Color(0xFF14161C))
                            .padding(horizontal = 7.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = tech,
                            fontSize = 10.5.sp,
                            color = Color(0xFFD4D4D8)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Action links (GitHub, Demo)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                if (project.github != null) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .border(0.8.dp, Color(0xFF333642), RoundedCornerShape(6.dp))
                            .background(Color(0xFF161820))
                            .clickable {
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                val clip = ClipData.newPlainText("GitHub", project.github)
                                clipboard.setPrimaryClip(clip)
                                Toast.makeText(context, "لینک گیت‌هاب کپی شد: ${project.github}", Toast.LENGTH_SHORT).show()
                            }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "گیت‌هاب پروژه",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = PolarisGoldBright
                        )
                    }
                }

                if (project.demo != null) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .border(0.8.dp, Color(0xFF333642), RoundedCornerShape(6.dp))
                            .background(Color(0xFF161820))
                            .clickable {
                                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                val clip = ClipData.newPlainText("Demo", project.demo)
                                clipboard.setPrimaryClip(clip)
                                Toast.makeText(context, "لینک دمو کپی شد: ${project.demo}", Toast.LENGTH_SHORT).show()
                            }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "مشاهده دمو",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = PolarisGoldBright
                        )
                    }
                }
            }
        }
    }
}
