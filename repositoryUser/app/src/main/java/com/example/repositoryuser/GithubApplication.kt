package com.example.repositoryuser

import android.app.Application
import timber.log.Timber

class GithubApplication : Application() {

    companion object {
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initAppComponent()
    }

    private fun initAppComponent() {

    }



}