package com.example.moviecheck

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MoviesApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}