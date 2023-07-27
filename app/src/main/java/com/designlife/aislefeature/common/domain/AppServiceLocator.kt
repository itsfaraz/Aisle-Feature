package com.designlife.aislefeature.common.domain

import android.content.Context
import com.designlife.aislefeature.authentication.data.api.AuthenticationApi
import com.designlife.aislefeature.authentication.domain.repository.AuthenticationRepository
import com.designlife.aislefeature.common.data.retrofit.RetrofitBuilder
import com.designlife.aislefeature.common.utils.Constants

object AppServiceLocator {
    private var authenticationRepository : AuthenticationRepository? = null

    fun provideAuthenticationRepository(context: Context): AuthenticationRepository{
        return authenticationRepository ?: createAuthenticationRepository(context)
    }

    private fun createAuthenticationRepository(context: Context): AuthenticationRepository {
        val authenticationApi : AuthenticationApi = RetrofitBuilder.getRetrofit(Constants.BASE_URL).create(AuthenticationApi::class.java)
        return AuthenticationRepository(authenticationApi)
    }
}