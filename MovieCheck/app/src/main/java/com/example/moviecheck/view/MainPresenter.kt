package com.example.moviecheck.view

import android.util.Log
import com.example.moviecheck.model.Movie
import com.example.moviecheck.source.DataSource
import javax.inject.Inject

class MainPresenter @Inject constructor(private var dataSource: DataSource<Movie>): MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun setView(view: MainContract.View) {
        this.view = view
        loadMovies()
    }

    override fun destroyView() {
        view = null
    }

    private fun loadMovies() {
        dataSource.run {
            getAll(object : DataSource.OnSuccessListener<Movie> {
                override fun onSuccess(list: List<Movie>) {
                    if (view != null) {
                        view!!.onMoviesLoaded(list)
                    }
                }
            }, object: DataSource.OnErrorListener {
                override fun onError(throwable: Throwable) {
                    Log.d("TEST", "Error while loading movies", throwable)
                }
            })
        }
    }

}