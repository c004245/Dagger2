package com.playgilround.schedule.client.dagger2

interface BaseView<T> {
    fun setPresenter(presenter: T)
}