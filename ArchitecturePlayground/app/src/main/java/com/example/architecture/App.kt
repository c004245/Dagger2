package com.example.architecture

import android.app.Application
import javax.inject.Inject

class App: Application() {

    @Inject lateinit var githubService: GithubService
    
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