package com.designlife.aislefeature.home.data.jdo

data class ProfileDataResponse(
    val invites : Invites?,
    val likes : Likes?,
){
    data class Invites(
        val profiles : List<Profiles>
    )
    data class Likes(
        val profiles : List<RecommendedProfile>
    )
}
