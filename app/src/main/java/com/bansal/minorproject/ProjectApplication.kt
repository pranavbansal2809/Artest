package com.bansal.minorproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class ProjectApplication : Application () {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
}