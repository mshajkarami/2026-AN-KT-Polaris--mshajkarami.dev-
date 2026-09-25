package ir.polaris.test.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.polaris.test.data.TeamData
import ir.polaris.test.ui.theme.PolarisGold
import ir.polaris.test.ui.theme.PolarisGoldBright
import ir.polaris.test.ui.theme.PolarisTextPrimary
import ir.polaris.test.ui.theme.PolarisTextSecondary

@Composable
fun PolarisContactSection(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Eyebrow matching reference
        Text(
            text = TeamData.CONTACT_EYEBROW,
            color = PolarisGold,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 2.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Title matching reference: "پروژه‌ای داری؟ با ما صحبت کن."
        Text(
            text = TeamData.CONTACT_TITLE,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 36.sp,
            color = PolarisTextPrimary,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // Email Outlined Box exactly as in the reference image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(6.dp))
                .border(1.dp, Color(0xFF2C2E38), RoundedCornerShape(6.dp))
                .background(Color(0xFF0F1014))
                .clickable {
                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText("Polaris Email", TeamData.CONTACT_EMAIL)
                    clipboard.setPrimaryClip(clip)

                    try {
                        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:${TeamData.CONTACT_EMAIL}")
                            putExtra(Intent.EXTRA_SUBJECT, "ارتباط با تیم Test - ارزیابی Polaris")
                        }
                        context.startActivity(emailIntent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "ایمیل کپی شد: ${TeamData.CONTACT_EMAIL}", Toast.LENGTH_SHORT).show()
                    }
                }
                .padding(vertical = 16.dp, horizontal = 20.dp)
                .testTag("contact_email_box"),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = TeamData.CONTACT_EMAIL,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = PolarisTextPrimary
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "✦",
                    color = PolarisGold,
                    fontSize = 11.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Social channels row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf(
                "تلگرام" to "https://t.me/polaris_test",
                "گیت‌هاب" to "https://github.com/polaris-test",
                "لینکدین" to "https://linkedin.com/company/polaris-test"
            ).forEach { (platform, link) ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(6.dp))
                        .border(0.8.dp, Color(0xFF242630), RoundedCornerShape(6.dp))
                        .background(Color(0xFF12141A))
                        .clickable {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = ClipData.newPlainText(platform, link)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "$platform کپی شد: $link", Toast.LENGTH_SHORT).show()
                        }
                        .padding(vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = platform,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = PolarisGoldBright
                    )
                }
            }
        }
    }
}
