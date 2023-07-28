package com.designlife.aislefeature.home.presentation.components

import android.graphics.Paint.Style
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.designlife.aislefeature.theme.AuthButtonColor
import com.designlife.aislefeature.theme.BottomBarSelectedItemColor
import com.designlife.aislefeature.theme.ButtonPrimary
import com.designlife.aislefeature.theme.PrimaryColor
import com.designlife.aislefeature.theme.authHeader

@Composable
fun SayHiComponent(
    message : String
) {
   Text(text = buildAnnotatedString {

       withStyle(style = SpanStyle(
           color = AuthButtonColor,
           fontSize = authHeader.fontSize,
           fontWeight = authHeader.fontWeight
       )
       ){
           append("Hii")
       }
       withStyle(style = SpanStyle(
           color = BottomBarSelectedItemColor,
           fontSize = authHeader.fontSize,
           fontWeight = authHeader.fontWeight
       )
       ){
           append("\n$message")
       }
   })
}