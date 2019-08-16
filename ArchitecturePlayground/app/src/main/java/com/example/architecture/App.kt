package com.example.architecture

import com.example.architecture.services.GithubService
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