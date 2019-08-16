package com.example.architecture.ui

import com.example.architecture.GithubService
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val githubService: GithubService)
)