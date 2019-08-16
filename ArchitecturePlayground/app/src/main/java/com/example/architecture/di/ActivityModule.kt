package com.example.architecture.di

import com.example.architecture.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun mainActivity(): MainActivity
}