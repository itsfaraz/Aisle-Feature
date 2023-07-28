package com.designlife.aislefeature.home.domain.repository

import com.designlife.aislefeature.common.data.retrofit.RetrofitBuilder
import com.designlife.aislefeature.home.data.api.NotesApi
import com.designlife.aislefeature.home.data.jdo.ProfileDataResponse

class NotesRepository(
    private val notesApi: NotesApi
) {

    suspend fun profileData(accessToken : String) : ProfileDataResponse?{
        RetrofitBuilder.ACCESS_TOKEN = accessToken
        val response = notesApi.fetchProfile()
        if (response.isSuccessful){
            return response.body()
        }
        return null
    }

}