package com.example.moviecheck.source

import com.example.moviecheck.model.Movie
import com.example.moviecheck.model.MovieApi
import com.example.moviecheck.model.MoviePage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MovieRemoteDataSource(private val movieApi: MovieApi): DataSource<Movie> {

    override fun getAll(
        onSuccessListener: DataSource.OnSuccessListener<Movie>,
        onErrorListener: DataSource.OnErrorListener
    ) {
        movieApi.getPopluar("b6ac59f519a117c958b639397726f0c6", 1).enqueue(object: Callback<MoviePage> {
            override fun onResponse(call: Call<MoviePage>, response: Response<MoviePage>) {
                if (response.isSuccessful && onSuccessListener != null) {
                    onSuccessListener.onSuccess(response.body()!!.results)
                } else if (onErrorListener != null) {
                    var errorMsg: String? = null
                    if (response.errorBody() != null) {
                        try {
                            errorMsg = response.errorBody()!!.string()
                        } catch (e: IOException) {

                        }
                    }

                    if (errorMsg == null) {
                        errorMsg = "Unknown: HTTP status code: " + response.code()
                    }
                    onErrorListener.onError(DataSourceException(errorMsg))
                }
            }

            override fun onFailure(call: Call<MoviePage>, t: Throwable) {
                if (onErrorListener != null) {
                    onErrorListener.onError(t)
                }
            }
        })
    }

}