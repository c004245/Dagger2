package com.example.architecture.ui.details

import com.example.architecture.base.BasePresenter
import com.example.architecture.base.BaseView
import com.example.architecture.services.GithubRepoEntity

interface DetailsContract {
    interface View: BaseView {
        fun startUrl(url: String)
        fun setToolbarTitle(title: String)
        fun setUrlAddress(url: String)
    }

    interface Presenter: BasePresenter<View> {
        fun onGoToRepositoryClicked()
        fun initData(githubRepoEntity: GithubRepoEntity)
    }
}