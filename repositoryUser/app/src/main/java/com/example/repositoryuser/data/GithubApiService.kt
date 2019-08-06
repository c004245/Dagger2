package com.example.repositoryuser.data

import com.example.repositoryuser.response.RepositoryResponse
import com.example.repositoryuser.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Single

interface GithubApiService {

    @GET("/users/{username}")
    fun getUser(@Path("username") userName: String) : Single<UserResponse>

    @GET("/users/{username}/repos")
    fun getUsersRepositories(@Path("username") userName: String) : Single<List<RepositoryResponse>>
}