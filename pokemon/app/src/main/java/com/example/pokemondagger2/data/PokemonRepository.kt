package com.example.pokemondagger2.data

import androidx.lifecycle.LiveData

interface PokemonRepository {
    fun getPokemon(): LiveData<List<Pokemon>>
}