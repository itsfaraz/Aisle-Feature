package com.designlife.aislefeature.authentication.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.R
import com.designlife.aislefeature.common.presentation.components.CustomInputComponent
import com.designlife.aislefeature.theme.AuthButtonColor
import com.designlife.aislefeature.theme.AuthButtonDisabledColor
import com.designlife.aislefeature.theme.authHeader
import com.designlife.aislefeature.theme.authHeaderSmall
import com.designlife.aislefeature.theme.buttonTextStyle

@Composable
fun AuthComponent(
    isLogin : Boolean,
    userNumber: String,
    countryCode: String,
    onEditEvent: () -> Unit,
    onCountryCodeEvent: (value : String) -> Unit,
    inputText: String,
    onInputChange: (value: String) -> Unit,
    countDownText : String,
    buttonVisibility : Boolean,
    onContinueEvent : () -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        AuthHeader(isLogin = isLogin, userNumber = userNumber, countryCode = countryCode){
            onEditEvent()
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = if(isLogin) stringResource(id = R.string.enter_phone_text)
            else stringResource(id = R.string.enter_otp_text),
            style = authHeader
        )
        Spacer(modifier = Modifier.height(12.dp))
        AuthInput(
            isLogin = isLogin,
            onCountryCodeEvent = { onCountryCodeEvent(it) },
            countryCode = countryCode,
            inputText = if (isLogin) userNumber else inputText,
            onInputChange = { onInputChange(it) },
        )
        Spacer(modifier = Modifier.height(20.dp))
        AuthButton(isLogin = isLogin, onCountDownText = countDownText ,buttonVisibility = buttonVisibility){onContinueEvent()}
    }

}

@Composable
fun AuthHeader(
    isLogin : Boolean,
    userNumber : String,
    countryCode : String,
    onEditEvent : () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isLogin){
            Text(text = stringResource(id = R.string.otp_text), style = authHeaderSmall)
        }else{
            Text(
                text = "+$countryCode $userNumber",
                style = authHeaderSmall,
                modifier = Modifier.wrapContentWidth()
            )
            Spacer(modifier = Modifier.width(7.dp))
            Icon(modifier = Modifier.clickable { onEditEvent() }, painter = painterResource(id = R.drawable.ic_fluent_edit), contentDescription = "Edit Icon")
        }
    }
}

@Composable
fun AuthInput(
    isLogin : Boolean,
    onCountryCodeEvent : (value : String) -> Unit,
    countryCode: String,
    inputText : String,
    onInputChange : (value : String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {
        if (isLogin){
            CustomInputComponent(modifier = Modifier
                .width(64.dp)
                .height(36.dp), input = countryCode, isClickable = isLogin, onInputChange = {  onCountryCodeEvent(it)}){}
            Spacer(modifier = Modifier.width(8.dp))
            CustomInputComponent(modifier = Modifier
                .width(148.dp)
                .height(36.dp), input = inputText, onInputChange = {onInputChange(it)})
        }else{
            CustomInputComponent(modifier = Modifier
                .width(78.dp)
                .height(36.dp), input = inputText, onInputChange = {onInputChange(it)})
        }
    }


}

@Composable
fun AuthButton(
    isLogin : Boolean,
    onCountDownText : String,
    buttonVisibility : Boolean,
    onButtonEvent : () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
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
            Text(text = stringResource(id = R.string.continue_text), textAlign = TextAlign.Center, style = buttonTextStyle)
        }
        Spacer(modifier = Modifier.width(12.dp))
        if (!isLogin){
            Text(text = if (onCountDownText.equals("00:00")) "Resend OTP" else onCountDownText, textAlign = TextAlign.Start, style = buttonTextStyle)
        }
    }

}