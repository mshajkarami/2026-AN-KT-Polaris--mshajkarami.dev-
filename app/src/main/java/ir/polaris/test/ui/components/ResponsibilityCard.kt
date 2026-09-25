package ir.polaris.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.model.Responsibility
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@Composable
fun ResponsibilityCard(
    item: Responsibility,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .border(1.dp, Color(0xFF23252E), RoundedCornerShape(8.dp))
            .background(Color(0xFF0F1014))
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Title
                Text(
                    text = item.title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = PolarisTextPrimary,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Status Pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF16231D))
                        .border(0.6.dp, Color(0xFF2A5941), RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = item.status,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF6EE7B7)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Assigned Member
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "مسئول:",
                    fontSize = 11.5.sp,
                    color = PolarisGold,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = item.responsibleMember,
                    fontSize = 12.sp,
                    color = PolarisGoldBright,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Description
            Text(
                text = item.description,
                fontSize = 12.5.sp,
                lineHeight = 20.sp,
                color = PolarisTextSecondary
            )
        }
    }
}
