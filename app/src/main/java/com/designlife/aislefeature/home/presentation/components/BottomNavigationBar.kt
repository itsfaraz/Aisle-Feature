package com.designlife.aislefeature.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.designlife.aislefeature.home.presentation.helper.ScreenType
import com.designlife.aislefeature.home.presentation.helper.BottomNavItem
import com.designlife.aislefeature.theme.PrimaryColor

@Composable
fun BottomNavigationBar(
    items : List<BottomNavItem>,
    selectedScreen : ScreenType,
    onItemSelected : (screenType : ScreenType) -> Unit
) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = PrimaryColor
    ) {
        items.forEachIndexed {index,item ->
            BottomNavigationItem(
                icon = {
                       Icon(modifier = Modifier.size(20.dp),painter = painterResource(id = item.icon), contentDescription = "icon")
                },
                label = {
                        Text(text = item.label)
                },
                selected = index == getItemIndex(selectedScreen),
                onClick = { onItemSelected(getScreenTypeFromIndex(index)) }
            )
        }
    }
}

private fun getScreenTypeFromIndex(index : Int) : ScreenType{
    return when(index){
        0 -> ScreenType.DISCOVER
        1 -> ScreenType.NOTES
        2 -> ScreenType.MATCHES
        3 -> ScreenType.PROFILE
        else -> ScreenType.DISCOVER
    }
}

private fun getItemIndex(navBarItem : ScreenType) : Int{
    return when(navBarItem){
        ScreenType.DISCOVER -> 0
        ScreenType.NOTES -> 1
        ScreenType.MATCHES -> 2
        ScreenType.PROFILE -> 3
    }
}