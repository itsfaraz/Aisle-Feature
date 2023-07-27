package com.designlife.aislefeature.common.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.theme.InputBorderColor
import com.designlife.aislefeature.theme.fieldTextStyle

@Composable
fun CustomInputComponent(
    modifier: Modifier,
    isClickable : Boolean = false,
    input : String,
    onInputChange : (value : String) -> Unit,
    onEvent : () -> Unit = {  }
) {
    BasicTextField(
        modifier = modifier
            .border(width = 1.dp, color = InputBorderColor, shape = RoundedCornerShape(8.dp))
            .clickable {
                onEvent()
            },
        value = input,
        onValueChange =  {
            onInputChange(it)
        },
        readOnly = false,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        )
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (isClickable && input.isNotBlank()) "+$input" else input,
                style = fieldTextStyle
            )
        }
    }
}