package com.designlife.aislefeature.home.data.jdo



data class Profiles(
    val general_information : GeneralInformation?,
    val photos : List<Photos>?
){
    data class GeneralInformation(
        val first_name : String?,
        val age : Int?
    )

    data class Photos(
        val photo : String?,
        val photo_id : Int?,
        val selected: Boolean?,
        val status : String?
    )
}
