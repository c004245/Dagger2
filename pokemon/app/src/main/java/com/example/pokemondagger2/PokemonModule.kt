package com.example.pokemondagger2

import com.example.pokemondagger2.data.PokemonRepository
import com.example.pokemondagger2.data.PokemonRepositoryImpl
import com.example.pokemondagger2.data.PokemonService
import com.example.pokemondagger2.ui.ViewPokemonActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class PokemonModule {

    @ContributesAndroidInjector
    abstract fun contributeViewPokemonActivity(): ViewPokemonActivity

    @Binds
    abstract fun bindRepo(impl: PokemonRepositoryImpl): PokemonRepository

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providePokemonService(): PokemonService {
            return Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService::class.java)
        }
    }
}