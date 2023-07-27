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

val fontFamily = FontFamily(
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

val headerStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamily,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium
)

val authHeader = TextStyle(
    color = Color.Black,
    fontFamily = fontFamily,
    fontSize = 30.sp,
    fontWeight = FontWeight.W800,
    lineHeight = 36.sp
)

val authHeaderSmall = TextStyle(
    color = Color.Black,
    fontFamily = fontFamily,
    fontSize = 18.sp,
    fontWeight = FontWeight.W500,
    lineHeight = 22.sp
)

val fieldTextStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamily,
    fontSize = 18.sp,
    fontWeight = FontWeight.W700,
    lineHeight = 22.sp
)


val buttonTextStyle = TextStyle(
    color = Color.Black,
    fontFamily = fontFamily,
    fontSize = 14.sp,
    fontWeight = FontWeight.W700,
    lineHeight = 22.sp
)


val contentStyle_One = TextStyle(
    color = Color.Black,
    fontFamily = fontFamily,
    fontSize = 10.sp,
    fontWeight = FontWeight.Medium
)