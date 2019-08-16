package com.example.architecture.services

import com.example.architecture.services.GithubApi
import com.example.architecture.services.GithubApiBuilder
import com.example.architecture.services.GithubRepoEntity
import io.reactivex.Observable
import javax.inject.Inject

class GithubService @Inject constructor(private val githubApiBuilder: GithubApiBuilder) {

    private val githubApi: GithubApi = githubApiBuilder.buildApi()

    fun fetchCodeRepos(username: String): Observable<List<GithubRepoEntity>> {
        return githubApi.fetchCodeRepos(username)

    }
}