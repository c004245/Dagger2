package com.example.pokemondagger2.ui

import com.example.pokemondagger2.data.PokemonRepository
import javax.inject.Inject

class ViewPokemonViewModel @Inject constructor(pokemonRepository: PokemonRepository) {

    val pokemon = pokemonRepository.getPokemon()
}
