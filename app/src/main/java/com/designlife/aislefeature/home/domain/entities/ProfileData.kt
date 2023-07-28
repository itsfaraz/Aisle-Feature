package com.designlife.aislefeature.home.domain.entities

data class ProfileData(
    val topNotes : List<TopNotes> = emptyList(),
    val profiles : List<LikedProfile> = emptyList()
){
    data class TopNotes(
        val firstName : String? = "",
        val age : Int? = null,
        val avatar : String? =" ",
    )

    data class LikedProfile(
        val firstName : String? = "",
        val avatar : String? = ""
    )
}
