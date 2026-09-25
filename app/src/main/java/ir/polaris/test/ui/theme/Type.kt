package ir.polaris.test.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.polaris.test.R

val IranYekan = FontFamily(
    Font(R.font.iran_yekan_l, FontWeight.Light),
    Font(R.font.iran_yekan_l, FontWeight.ExtraLight),
    Font(R.font.iran_yekan_l, FontWeight.Thin),
    Font(R.font.iran_yekan_regular, FontWeight.Normal),
    Font(R.font.iran_yekan_regular, FontWeight.Medium),
    Font(R.font.iran_yekan_regular, FontWeight.SemiBold),
    Font(R.font.iran_yekan_regular, FontWeight.Bold),
    Font(R.font.iran_yekan_regular, FontWeight.ExtraBold),
    Font(R.font.iran_yekan_regular, FontWeight.Black)
)

val AppFontFamily = IranYekan

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Medium,
        fontSize = 44.sp,
        lineHeight = 52.sp,
        letterSpacing = 2.sp,
        color = PolarisTextPrimary
    ),
    displayMedium = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 38.sp,
        letterSpacing = 0.sp,
        color = PolarisTextPrimary
    ),
    displaySmall = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
        color = PolarisTextPrimary
    ),
    headlineLarge = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 30.sp,
        color = PolarisTextPrimary
    ),
    headlineMedium = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = PolarisTextPrimary
    ),
    headlineSmall = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 26.sp,
        color = PolarisTextPrimary
    ),
    titleLarge = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 26.sp,
        color = PolarisTextPrimary
    ),
    titleMedium = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 24.sp,
        color = PolarisTextPrimary
    ),
    titleSmall = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 22.sp,
        color = PolarisTextPrimary
    ),
    bodyLarge = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 26.sp,
        color = PolarisTextSecondary
    ),
    bodyMedium = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 22.sp,
        color = PolarisTextSecondary
    ),
    bodySmall = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        color = PolarisTextMuted
    ),
    labelLarge = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp,
        color = PolarisTextPrimary
    ),
    labelMedium = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        color = PolarisTextPrimary
    ),
    labelSmall = TextStyle(
        fontFamily = IranYekan,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 1.sp,
        color = PolarisGold
    )
)
