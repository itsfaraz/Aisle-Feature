package com.designlife.aislefeature.authentication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.designlife.aislefeature.authentication.domain.repository.AuthenticationRepository

class AuthenticationViewModelFactory(
    private val authenticationRepository: AuthenticationRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthenticationViewModel(authenticationRepository) as T
    }
}