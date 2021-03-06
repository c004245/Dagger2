package com.example.architecture.di

import com.example.architecture.App
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class
    ]
)
interface AndroidPlaygroundComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        fun build(): AndroidPlaygroundComponent
    }
}