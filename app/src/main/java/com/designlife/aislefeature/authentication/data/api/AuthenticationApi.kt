package com.designlife.aislefeature.authentication.data.api

import com.designlife.aislefeature.authentication.data.jdo.request.OtpRequest
import com.designlife.aislefeature.authentication.data.jdo.response.StatusResponse
import com.designlife.aislefeature.authentication.data.jdo.request.TokenRequest
import com.designlife.aislefeature.authentication.data.jdo.response.TokenResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("V1/users/phone_number_login")
    suspend fun fetchOTP(
        @Body otpRequest : OtpRequest
    )  : Response<StatusResponse>

    @POST("V1/users/verify_otp")
    suspend fun verifyOTP(
        @Body tokenRequest: TokenRequest,
    )  : Response<TokenResponse>

}