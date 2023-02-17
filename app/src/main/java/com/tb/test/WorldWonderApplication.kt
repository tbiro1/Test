package com.tb.test

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WorldWonderApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}