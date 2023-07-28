package com.designlife.aislefeature.common.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.R
import com.designlife.aislefeature.theme.AuthButtonColor
import com.designlife.aislefeature.theme.AuthButtonDisabledColor
import com.designlife.aislefeature.theme.buttonTextStyle

@Composable
fun CustomButton(
    buttonText : String,
    buttonVisibility : Boolean = true,
    onButtonEvent : () -> Unit
) {
    Button(
        onClick = { onButtonEvent() },
        modifier = Modifier
            .width(96.dp)
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AuthButtonColor,
            disabledBackgroundColor = AuthButtonDisabledColor
        ),
        shape = RoundedCornerShape(20.dp),
        enabled = buttonVisibility
    ) {
        Text(text = buttonText, textAlign = TextAlign.Center, style = buttonTextStyle)
    }


}