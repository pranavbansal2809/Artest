package com.bansal.minorproject.ui.login.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {

    enum class RegistrationState {
        UNREGISTERED,
        USER_CREATED,
        BASIC_DETAILS_ENTERED,
        DATE_TIME_TAKEN,
        REGISTRATION_COMPLETE
    }

    val registrationState = MutableLiveData<RegistrationState>(RegistrationState.UNREGISTERED)

    fun createBasicUser(email: String, password: String) {
        registrationState.value = RegistrationState.USER_CREATED
    }
    fun collectDetails() {
        registrationState.value = RegistrationState.BASIC_DETAILS_ENTERED
    }
    fun collectDateAndTimeDetails() {
        registrationState.value = RegistrationState.DATE_TIME_TAKEN
    }
    fun collectMusicalPreferences() {
        registrationState.value = RegistrationState.REGISTRATION_COMPLETE
    }
}