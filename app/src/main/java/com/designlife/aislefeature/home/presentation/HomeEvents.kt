package com.designlife.aislefeature.home.presentation

import com.designlife.aislefeature.home.presentation.helper.ScreenType

sealed class HomeEvents {
    data class OnItemSelected(val screenType : ScreenType) : HomeEvents()
    data class OnTokenUpdate(val token : String) : HomeEvents()
}