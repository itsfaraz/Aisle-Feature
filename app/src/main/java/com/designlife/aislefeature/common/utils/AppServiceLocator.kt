package com.designlife.aislefeature.common.utils

import android.content.Context
import com.designlife.aislefeature.authentication.data.api.AuthenticationApi
import com.designlife.aislefeature.authentication.domain.repository.AuthenticationRepository
import com.designlife.aislefeature.common.data.retrofit.RetrofitBuilder
import com.designlife.aislefeature.home.data.api.NotesApi
import com.designlife.aislefeature.home.domain.repository.NotesRepository

object AppServiceLocator {
    private var authenticationRepository : AuthenticationRepository? = null
    private var notesRepository : NotesRepository? = null

    fun provideAuthenticationRepository(context: Context): AuthenticationRepository{
        return authenticationRepository ?: createAuthenticationRepository(context)
    }

    fun provideNotesRepository(context: Context): NotesRepository{
        return notesRepository ?: createNotesRepository(context)
    }

    private fun createAuthenticationRepository(context: Context): AuthenticationRepository {
        val authenticationApi : AuthenticationApi = RetrofitBuilder.getRetrofit(Constants.BASE_URL).create(AuthenticationApi::class.java)
        return AuthenticationRepository(authenticationApi)
    }

    private fun createNotesRepository(context: Context): NotesRepository {
        val notesApi : NotesApi = RetrofitBuilder.getRetrofit(Constants.BASE_URL).create(NotesApi::class.java)
        return NotesRepository(notesApi)
    }
}