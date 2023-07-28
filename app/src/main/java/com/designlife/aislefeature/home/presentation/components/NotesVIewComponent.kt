package com.designlife.aislefeature.home.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.designlife.aislefeature.R
import com.designlife.aislefeature.home.domain.entities.ProfileData
import com.designlife.aislefeature.theme.profileImageContentStyle
import com.designlife.aislefeature.theme.profileImageStyle

@Composable
fun TopNotesComponent(
    topNotes : ProfileData.TopNotes,
    onClickEvent : () -> Unit
) {

    Box(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()
        .height(344.dp)
      ,
        contentAlignment = Alignment.BottomEnd
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(344.dp)
                .clip(RoundedCornerShape(15.dp)),
            model = topNotes.avatar,
            contentDescription = "Avatar",
            contentScale = ContentScale.FillBounds
        )
        ImageMetaData(firstName = topNotes.firstName ?: "", age = if (topNotes.age != null) topNotes.age.toString() else "")
    }
}

@Composable
fun ImageMetaData(
    firstName : String,
    age : String
) {
    Column(
        modifier = Modifier
            .padding(start = 18.dp)
            .fillMaxWidth(),

    ) {
        Text(
            text = "$firstName, $age",
            style = profileImageStyle
        )
        Text(
            text = stringResource(id = R.string.review_notes),
            style = profileImageContentStyle
        )
    }
}