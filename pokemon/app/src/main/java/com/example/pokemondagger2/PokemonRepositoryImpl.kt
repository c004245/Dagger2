package com.example.pokemondagger2

import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val service: PokemonService,
    private val cache: PokemonCache): PokemonRepository {

}
