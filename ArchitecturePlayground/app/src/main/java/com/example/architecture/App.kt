package com.example.architecture

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App: DaggerApplication() {

    @Inject lateinit var githubService: GithubService

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAndroidPlaygroundComponent.builder()
            .build()
    }
}