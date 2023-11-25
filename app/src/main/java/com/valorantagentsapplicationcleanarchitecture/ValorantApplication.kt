package com.valorantagentsapplicationcleanarchitecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ValorantApplication : Application(){
    override fun onCreate() {
        super.onCreate()
    }
}