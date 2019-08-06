package com.example.repositoryuser.module

import com.example.repositoryuser.splash.SplashActivity
import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule constructor(private val splashActivity: SplashActivity) {

    @Provides
    fun provideSplashActivity(): SplashActivity {
        return splashActivity
    }

    @Provides
    fun provideSplashActivityPresenter(): SPlashActiv

}