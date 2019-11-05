package com.bansal.minorproject.data

import android.app.Activity
import android.content.Context
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth

class FirebaseAuthHelper (private val mAuth: FirebaseAuth) {

    private var user = mAuth.currentUser

    fun checkAuthentication() = user != null
    fun getDisplayName() = user?.displayName ?: ""

    fun signUpUser(email: String, password: String): Boolean {
        var isRegistered = false
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task -> isRegistered = task.isSuccessful    }

        return isRegistered
    }

    fun signInUser(email: String, password: String): Boolean {
        var isLoggedIn = false
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task -> isLoggedIn = task.isSuccessful }

        return isLoggedIn
    }

    fun signInWithFacebook(context: Context, callbackManager: CallbackManager) {
        val loginManager = LoginManager.getInstance()

        loginManager.logInWithReadPermissions(context as Activity, mutableListOf("email", "public_profile"))
        loginManager.registerCallback(callbackManager, object: FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {

            }

            override fun onCancel() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(error: FacebookException?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    fun signInWithGoogle() {}

    fun handeAuth(credential: AuthCredential): Boolean {
        var loginSuccessful = false
        mAuth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                user = mAuth.currentUser
                loginSuccessful = true
            }
        }

        return loginSuccessful
    }
}