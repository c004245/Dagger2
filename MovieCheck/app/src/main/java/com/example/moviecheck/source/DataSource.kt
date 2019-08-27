package com.example.moviecheck.source

interface DataSource<T> {

    fun getAll(onSuccessListener: OnSuccessListener<T>, onErrorListener: OnErrorListener)

    interface OnSuccessListener<T> {
        fun onSuccess(list: List<T>)
    }

    interface OnErrorListener {
        fun onError(throwable: Throwable)
    }
}