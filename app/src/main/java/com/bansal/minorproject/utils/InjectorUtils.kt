package com.bansal.minorproject.utils

import com.bansal.minorproject.data.FirebaseAuthHelper
import com.google.firebase.auth.FirebaseAuth

class InjectorUtils {

    companion object {

        fun provideFirebaseAuthHelper(mAuth: FirebaseAuth) = FirebaseAuthHelper(mAuth)
    }
}