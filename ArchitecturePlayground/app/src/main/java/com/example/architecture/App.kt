package com.example.architecture

import android.app.Application

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        configureDagger()
    }

    private fun configureDagger() {
        DaggerAndroidPlaygroundComponent.builder()
            .build()
            .inject(this)
    }
}