package com.designlife.aislefeature.authentication.presentation

sealed class AuthenticationEvents {
    object OnEditEvent : AuthenticationEvents()
    data class OnInputChange(val input : String) : AuthenticationEvents()
    data class OnCountryCodeChange(val input : String) : AuthenticationEvents()
    object OnContinueEvent : AuthenticationEvents()
}