package com.designlife.aislefeature.common.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.theme.AuthButtonColor


@Composable
fun CustomProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.size(40.dp),
        color = AuthButtonColor,
        strokeWidth = 4.dp
    )
}