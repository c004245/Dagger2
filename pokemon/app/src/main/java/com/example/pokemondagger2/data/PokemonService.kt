package com.example.pokemondagger2.data

import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon?limit=999")
    fun getAll(): Call<PokemonResponse>
}