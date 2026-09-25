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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.data.TeamData
import ir.polaris.test.model.CollaborationStep
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@Composable
fun CollaborationTimeline(
    steps: List<CollaborationStep> = TeamData.collaborationSteps,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        steps.forEachIndexed { index, step ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Indicator column (circle + vertical connecting line)
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.width(36.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF161820))
                            .border(1.dp, PolarisGold, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "${step.stepNumber}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace,
                            color = PolarisGoldBright
                        )
                    }

                    if (index < steps.size - 1) {
                        Box(
                            modifier = Modifier
                                .width(1.5.dp)
                                .height(56.dp)
                                .background(Color(0xFF282A35))
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Step content card
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = if (index < steps.size - 1) 16.dp else 0.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .border(0.8.dp, Color(0xFF22242D), RoundedCornerShape(8.dp))
                        .background(Color(0xFF0F1014))
                        .padding(14.dp)
                ) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = step.title,
                                fontSize = 14.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = PolarisTextPrimary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "•  ${step.subtitle}",
                                fontSize = 11.sp,
                                color = PolarisGold,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = step.description,
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
                            color = PolarisTextSecondary
                        )
                    }
                }
            }
        }
    }
}
