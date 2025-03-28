package org.company.test.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import multiplatform_app_for_test.composeapp.generated.resources.IndieFlower_Regular
import multiplatform_app_for_test.composeapp.generated.resources.NotoSansArabic
import multiplatform_app_for_test.composeapp.generated.resources.NotoSansArabic_Bold
import multiplatform_app_for_test.composeapp.generated.resources.NotoSansArabic_Light
import multiplatform_app_for_test.composeapp.generated.resources.NotoSansArabic_Medium
import multiplatform_app_for_test.composeapp.generated.resources.NotoSansArabic_SemiBold
import multiplatform_app_for_test.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TekoFontFamily() = FontFamily(
    Font(Res.font.NotoSansArabic_Light, weight = FontWeight.Light),
    Font(Res.font.NotoSansArabic, weight = FontWeight.Normal),
    Font(Res.font.NotoSansArabic_Medium, weight = FontWeight.Medium),
    Font(Res.font.NotoSansArabic_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.NotoSansArabic_Bold, weight = FontWeight.Bold)
)

@Composable
fun TekoTypography() = Typography().run {

    val fontFamily = TekoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily),
    )
}