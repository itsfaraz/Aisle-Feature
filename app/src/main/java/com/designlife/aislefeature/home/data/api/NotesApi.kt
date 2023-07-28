package com.designlife.aislefeature.home.data.api

import com.designlife.aislefeature.home.data.jdo.ProfileDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NotesApi {
    @GET("V1/users/test_profile_list")
    suspend fun fetchProfile() : Response<ProfileDataResponse>

}