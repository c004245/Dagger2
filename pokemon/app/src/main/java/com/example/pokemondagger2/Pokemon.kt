package com.example.pokemondagger2

data class Pokemon (val name: String)

data class PokemonResponse(val results: List<Pokemon>)