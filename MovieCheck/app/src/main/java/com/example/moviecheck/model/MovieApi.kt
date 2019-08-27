package com.example.moviecheck.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    fun getPopluar(@Query("api_key") apiKey: String, @Query("page") page: Int): Call<MoviePage>
}

class MoviePage {

    lateinit var results: List<Movie>
}