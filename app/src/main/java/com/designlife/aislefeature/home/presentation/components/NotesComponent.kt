package com.designlife.aislefeature.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.R
import com.designlife.aislefeature.theme.contentHeaderStyle
import com.designlife.aislefeature.theme.contentSubHeaderStyle

@Composable
fun NotesComponent() {

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize(),

    ) {
        Spacer(modifier = Modifier.height(32.dp))
        NotesText()

    }

}

@Composable
fun NotesText() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(id = R.string.notes_text), style = contentHeaderStyle)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(id = R.string.notes_message), style = contentSubHeaderStyle)
    }
}
