package com.example.architecture.base

interface BasePresenter<in T: BaseView> {
    fun attachView(view: T)
    fun detachView()
}