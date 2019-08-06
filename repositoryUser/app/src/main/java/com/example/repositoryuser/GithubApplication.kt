package com.example.repositoryuser

import android.app.Application
import android.content.Context
import com.example.repositoryuser.component.AppComponent
import com.example.repositoryuser.component.UserComponent
import timber.log.Timber

class GithubApplication : Application() {

    private lateinit var appComponent: AppComponent
    private lateinit var userComponent: UserComponent

    operator fun get(context: Context): GithubApplication {
        return context.applicationContext as GithubApplication
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = Dagger
    }



}