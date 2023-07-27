package com.designlife.aislefeature.authentication.data.api

import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationApi {

    @POST("/users/phone_number_login")
    suspend fun fetchOTP(
        @Query("number",encoded = false) number : String
    ) // : Response<>

    @POST("/users/verify_otp")
    suspend fun verifyOTP(
        @Query("number",encoded = false) number: String,
        @Query("otp",encoded = false) otp : String
    ) // : Response<>

}