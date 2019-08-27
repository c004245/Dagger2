package com.example.moviecheck.view

import com.example.moviecheck.model.Movie

interface MainContract {

    interface View {
        fun onMoviesLoaded(movies: List<Movie>)
    }

    interface Presenter {

        fun setView(view: View)

        fun destroyView()
    }
}