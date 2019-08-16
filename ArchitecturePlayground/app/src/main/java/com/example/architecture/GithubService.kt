package com.example.architecture

import javax.inject.Inject

class GithubService @Inject constructor(private val githubApiBuilder: GithubApiBuilder) {

    private val githubApi: GithubApi = githubApiBuilder.buildApi()

    fun fetchRepos(username: String) {

    }
}