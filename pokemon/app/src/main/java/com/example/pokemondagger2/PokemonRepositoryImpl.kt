package com.example.pokemondagger2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.Executors
import javax.inject.Inject

private val executor = Executors.newSingleThreadExecutor()

class PokemonRepositoryImpl @Inject constructor(
    private val service: PokemonService,
    private val cache: PokemonCache): PokemonRepository {

    override fun getPokemon(): LiveData<List<Pokemon>> {
        val liveData = MutableLiveData<List<Pokemon>>()
        executor.execute {
            if (cache.hasdD)
        }
    }

}
