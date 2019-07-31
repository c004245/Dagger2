package com.playgilround.schedule.client.dagger2.presenter

import com.playgilround.schedule.client.dagger2.BasePresenter
import com.playgilround.schedule.client.dagger2.BaseView

interface MainContract {

    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}