package com.designlife.aislefeature.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.designlife.aislefeature.R


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

val fontFamilyInter = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_medium, weight = FontWeight.Medium),
    Font(R.font.inter_black, weight = FontWeight.Normal),
    Font(R.font.inter_bold, weight = FontWeight.Bold),
    Font(R.font.inter_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.inter_extralight, weight = FontWeight.ExtraLight),
    Font(R.font.inter_light, weight = FontWeight.Light),
    Font(R.font.inter_semibold, weight = FontWeight.SemiBold),
    Font(R.font.inter_thin, weight = FontWeight.Thin)
)

val fontFamilyGilRoy = FontFamily(
    Font(R.font.gilroy_regular),
    Font(R.font.gilroy_medium, weight = FontWeight.Medium),
    Font(R.font.gilroy_black, weight = FontWeight.Normal),
    Font(R.font.gilroy_bold, weight = FontWeight.Bold),
    Font(R.font.gilroy_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.gilroy_light, weight = FontWeight.Light),
    Font(R.font.gilroy_semibold, weight = FontWeight.SemiBold),
    Font(R.font.gilroy_thin, weight = FontWeight.Thin)
)

val headerStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyInter,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium
)

val authHeader = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyInter,
    fontSize = 30.sp,
    fontWeight = FontWeight.W800,
    lineHeight = 36.sp
)

val authHeaderSmall = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyInter,
    fontSize = 18.sp,
    fontWeight = FontWeight.W500,
    lineHeight = 22.sp
)

val fieldTextStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyInter,
    fontSize = 18.sp,
    fontWeight = FontWeight.W700,
    lineHeight = 22.sp
)


val buttonTextStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyInter,
    fontSize = 14.sp,
    fontWeight = FontWeight.W700,
    lineHeight = 22.sp
)


val contentStyle_One = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyInter,
    fontSize = 10.sp,
    fontWeight = FontWeight.Medium
)

val contentHeaderStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyGilRoy,
    fontSize = 27.sp,
    fontWeight = FontWeight.W800,
    lineHeight = 33.sp
)

val contentSubHeaderStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamilyGilRoy,
    fontSize = 18.sp,
    fontWeight = FontWeight.W600,
    lineHeight = 21.sp
)

val profileImageStyle = TextStyle(
    color = Color.White,
    fontFamily = fontFamilyGilRoy,
    fontSize = 22.sp,
    fontWeight = FontWeight.W800,
    lineHeight = 22.sp
)

val profileImageContentStyle = TextStyle(
    color = Color.White,
    fontFamily = fontFamilyGilRoy,
    fontSize = 15.sp,
    fontWeight = FontWeight.W600,
    lineHeight = 18.sp
)