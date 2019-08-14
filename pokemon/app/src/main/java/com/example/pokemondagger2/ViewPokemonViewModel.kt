package com.example.pokemondagger2

import javax.inject.Inject

class ViewPokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository) {

    fun getPokemon() = pokemonRepository.getPokemon()
}
