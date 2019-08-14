package com.example.pokemondagger2

import androidx.lifecycle.LiveData

interface PokemonRepository {
    fun getPokemon(): LiveData<List<Pokemon>>
}