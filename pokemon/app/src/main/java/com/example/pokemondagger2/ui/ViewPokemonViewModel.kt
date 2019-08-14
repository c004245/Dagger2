package com.example.pokemondagger2.ui

import com.example.pokemondagger2.data.PokemonRepository
import javax.inject.Inject

class ViewPokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    fun getPokemon() = pokemonRepository.getPokemon()
}
