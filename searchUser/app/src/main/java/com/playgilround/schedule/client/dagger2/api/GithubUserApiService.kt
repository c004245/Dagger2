package com.playgilround.schedule.client.dagger2.api

import com.playgilround.schedule.client.dagger2.model.SearchResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubUserApiService {

    @GET("/search/users")
    fun getUserData(
        @Query("q") searchWord: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ) : Observable<SearchResponse>
}