package com.example.architecture.ui

import com.example.architecture.base.BasePresenter
import com.example.architecture.base.BaseView
import com.example.architecture.services.GithubRepoEntity

interface MainContract {
    interface View: BaseView {
        fun showResults(results: List<GithubRepoEntity>)
        fun showProgress()
        fun hideProgress()
    }

    interface Presenter: BasePresenter<View> {
        fun loadResults()
    }
}