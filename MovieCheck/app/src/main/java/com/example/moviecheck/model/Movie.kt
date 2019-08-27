package com.example.moviecheck.model

import com.google.gson.annotations.SerializedName

class Movie {

    var id: Int = 0
    var title: String = ""

    @SerializedName("poster_path")
    var posterPath: String = ""

}