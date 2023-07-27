package com.designlife.aislefeature.authentication.domain.repository

import com.designlife.aislefeature.authentication.data.api.AuthenticationApi
import kotlinx.coroutines.delay

class AuthenticationRepository(
    private val authenticationApi : AuthenticationApi
) {


    suspend fun fetchOtpOf(number : String) : Boolean{
//        val response = authenticationApi.fetchOTP(number)
        delay(3000)
        return true
    }

    suspend fun verifyOtpOf(number : String,otp : String) : Boolean{
//        val response = authenticationApi.verifyOTP(number, otp)
        delay(2000)
        return true
    }

}