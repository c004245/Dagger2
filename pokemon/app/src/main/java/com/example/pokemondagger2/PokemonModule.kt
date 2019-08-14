package com.example.pokemondagger2

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PokemonModule {

    @ContributesAndroidInjector
    abstract fun contributeViewPokemonActivity(): ViewPokemonActivity
}