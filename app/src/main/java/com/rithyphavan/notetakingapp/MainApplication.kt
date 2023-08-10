package com.rithyphavan.notetakingapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {

    companion object {
        @Volatile
        private var instance: MainApplication? = null

        /**
         * Normally we would create singleton with koin or hilt DI but since this is a small we might
         * have to go that far
         */
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MainApplication().also { instance = it }
        }
    }
}