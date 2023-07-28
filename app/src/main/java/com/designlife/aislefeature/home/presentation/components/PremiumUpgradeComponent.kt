package com.designlife.aislefeature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.R
import com.designlife.aislefeature.common.presentation.components.CustomButton
import com.designlife.aislefeature.theme.profileImageContentStyle
import com.designlife.aislefeature.theme.profileImageStyle

@Composable
fun PremiumUpgradeComponent(
    onPremiumEvent : () -> Unit
) {

    Row(
        modifier = Modifier
            .padding(start = 25.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
    ) {
        Column(
            modifier = Modifier
                .padding(start = 5.dp)
                .wrapContentWidth()
                .fillMaxHeight()
        ) {
            Text(text = stringResource(id = R.string.interested_note), style = profileImageStyle.copy(color = Color.Black))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = stringResource(id = R.string.premium_update_msg), style = profileImageContentStyle.copy(color = Color.Black))
        }
        Column(
            modifier = Modifier.padding(end = 15.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            CustomButton(buttonText = stringResource(id = R.string.upgrade_text)) {
                onPremiumEvent()
            }
        }
    }

}