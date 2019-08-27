package com.example.moviecheck.source

interface DataSource<T> {

    fun getAll(onSuccessListener: OnSuccessListener<T>, onErrorListener: onErrorListener)

    interface OnSuccessListener<T> {
        fun onSuccess(list: List<T>)
    }

    interface OnErrorListener {
        fun onError(throwable: Throwable)
    }
}