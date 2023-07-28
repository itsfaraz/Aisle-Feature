package com.designlife.aislefeature.authentication.domain.repository

import com.designlife.aislefeature.authentication.data.api.AuthenticationApi
import com.designlife.aislefeature.authentication.data.jdo.request.OtpRequest
import com.designlife.aislefeature.authentication.data.jdo.response.StatusResponse
import com.designlife.aislefeature.authentication.data.jdo.request.TokenRequest

class AuthenticationRepository(
    private val authenticationApi : AuthenticationApi
) {

    suspend fun fetchOtpOf(number : String) : Boolean{
        val response = authenticationApi.fetchOTP(OtpRequest(number))

        if (response.isSuccessful){
            response.body()?.let {
                val status : StatusResponse = it

                return it.status
            }
        }
        return false
    }

    suspend fun fetchTokenOf(number : String, otp : String) : String?{
        val response = authenticationApi.verifyOTP(TokenRequest(number,otp))
        response.body()?.let {
            return it.token
        }
        return ""
    }

}