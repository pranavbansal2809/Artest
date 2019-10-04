package com.bansal.minorproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bansal.minorproject.R
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)
    }
}
