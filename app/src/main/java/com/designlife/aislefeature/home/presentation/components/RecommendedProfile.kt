package com.designlife.aislefeature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.designlife.aislefeature.theme.profileImageStyle

@Composable
fun RecommendedProfile(
    avatar : String,
    name : String
) {
    Box(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            modifier = Modifier
                .width(168.dp)
                .height(255.dp)
                .clip(RoundedCornerShape(15.dp)),
            model = avatar,
            contentDescription = "Avatar",
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(start = 10.dp).wrapContentWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = name, style = profileImageStyle.copy(
                    color = Color.White,
                    fontSize = 18.sp
                )
            )
        }

    }
}