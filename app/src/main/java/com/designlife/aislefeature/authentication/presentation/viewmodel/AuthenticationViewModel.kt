package com.designlife.aislefeature.authentication.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.designlife.aislefeature.authentication.domain.repository.AuthenticationRepository
import com.designlife.aislefeature.authentication.presentation.AuthenticationEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthenticationViewModel(
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    private val _isLogin : MutableState<Boolean> = mutableStateOf(true)
    val isLogin = _isLogin

    private val _buttonVisibility : MutableState<Boolean> = mutableStateOf(false)
    val buttonVisibility = _buttonVisibility

    private val _progressBar : MutableState<Boolean> = mutableStateOf(false)
    val progressBar = _progressBar

    private val _userNumber : MutableState<String> = mutableStateOf("")
    val userNumber = _userNumber

    private val _countryCode : MutableState<String> = mutableStateOf("")
    val countryCode = _countryCode

    private val _otpNumber : MutableState<String> = mutableStateOf("")
    val otpNumber = _otpNumber

    private val _token : MutableState<String> = mutableStateOf("")
    val token = _token

    private val _countDown : MutableState<Int> = mutableStateOf(60)
    val countDown = _countDown

    private val _isUserVerified : MutableState<Boolean> = mutableStateOf(false)
    val isUserVerified = _isUserVerified

    private var job : Job? = null

    fun onEvent(event : AuthenticationEvents){
        when(event){
            is AuthenticationEvents.OnEditEvent -> {
                _isLogin.value = true
                _progressBar.value = false
                this.resetAuth()
            }
            is AuthenticationEvents.OnInputChange -> {
                if (_isLogin.value){
                    _userNumber.value = event.input
                    checkValidationForNumber()
                }else{
                    _otpNumber.value = event.input
                    checkValidationForOtp()
                }
            }
            is AuthenticationEvents.OnCountryCodeChange -> {
                _countryCode.value = event.input
            }
            is AuthenticationEvents.OnContinueEvent -> {
                if (_isLogin.value) {
                    launchOtpRequest()
                    checkValidationForOtp()
                }else{
                    launchVerifyOtpRequest()
                    checkValidationForOtp()
                }
            }
        }
    }

    private fun checkValidationForOtp(): Boolean {
        _buttonVisibility.value = _userNumber.value.isNotEmpty() && _countryCode.value.isNotEmpty() && _otpNumber.value.isNotEmpty();
        return _buttonVisibility.value
    }

    private fun checkValidationForNumber(): Boolean {
        _buttonVisibility.value = _userNumber.value.isNotEmpty() && _countryCode.value.isNotEmpty();
        return _buttonVisibility.value
    }

    private fun launchVerifyOtpRequest() {
        _progressBar.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val token = authenticationRepository.fetchTokenOf("+${_countryCode.value}${_userNumber.value}",_otpNumber.value)
            if (!token.isNullOrEmpty()){
//                storeUserSession()
                _token.value = token
            }

            withContext(Dispatchers.Main){
                if (!token.isNullOrEmpty()){
                    _isUserVerified.value = true
                }
                _progressBar.value = false
            }
        }
    }

    private fun launchOtpRequest() {
        _progressBar.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val status = authenticationRepository.fetchOtpOf("+${_countryCode.value}${_userNumber.value}")
            if (status){
                withContext(Dispatchers.Main){
                    _isLogin.value = false
                    _progressBar.value = false
                    initiateCountDown()
                }
            }
            _progressBar.value = false
        }
    }

    fun resetAuth(){
        this._isLogin.value = true;
        this._userNumber.value = ""
        this._countryCode.value = ""
        this._otpNumber.value = ""
        this._countDown.value = 60
        _isUserVerified.value = false
        _buttonVisibility.value = false
        job?.cancel()
    }

    private fun initiateCountDown(){
        job = viewModelScope.launch(Dispatchers.Default) {
           while (_countDown.value != 0){
               _countDown.value -= 1;
               delay(1000)
           }
        }
    }
}