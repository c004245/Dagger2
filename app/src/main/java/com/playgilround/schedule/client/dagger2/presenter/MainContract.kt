package com.playgilround.schedule.client.dagger2.presenter

import com.playgilround.schedule.client.dagger2.BasePresenter
import com.playgilround.schedule.client.dagger2.BaseView
import com.playgilround.schedule.client.dagger2.model.SearchResponse

interface MainContract {

    interface View : BaseView<Presenter> {
        fun onDataLoaded(storeResponse: SearchResponse)
        fun onDataFailed()
    }

    interface Presenter : BasePresenter {
        fun getGithubUserList(q: String)
    }
}