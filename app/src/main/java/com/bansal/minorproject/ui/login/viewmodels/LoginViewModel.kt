package com.bansal.minorproject.ui.login.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    enum class AuthenticationState {
        UNAUTHENTICATED,
        AUTHENTICATED,
        INVALID_AUTHENTICATION
    }

    val authenticationState = MutableLiveData<AuthenticationState>()
    private var username: String

    init {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
        username = ""
    }

    fun cancelAuth() {
        authenticationState.value = AuthenticationState.UNAUTHENTICATED
    }

    fun authenticate() {
    }
}