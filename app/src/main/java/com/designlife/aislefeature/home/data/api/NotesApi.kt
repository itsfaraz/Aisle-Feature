package com.designlife.aislefeature.home.data.api

import retrofit2.http.GET

interface NotesApi {

    @GET("/users/test_profile_list")
    suspend fun fetchProfile(

    )

}