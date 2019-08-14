package com.example.pokemondagger2

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class
])
interface AppComponent: AndroidInjector<PokemonApplication>