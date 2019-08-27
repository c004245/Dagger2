package com.example.moviecheck.di

import android.app.Application
import com.example.moviecheck.ActivityBindingModule
import com.example.moviecheck.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class,
            ActivityBindingModule::class,
            AndroidInjectionModule::class,
            AndroidSupportInjectionModule::class])
interface AppComponent: AndroidInjector<DaggerApplication> {

    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}