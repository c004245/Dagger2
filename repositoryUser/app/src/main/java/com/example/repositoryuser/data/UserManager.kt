package com.example.repositoryuser.data

import com.example.repositoryuser.model.User
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class UserManager constructor(private var githubApiService: GithubApiService){

    fun getUser(userName: String): Single<User> {
        return githubApiService.getUser(userName)
            .map { userResponse ->
                val user = User()
                user.login = userResponse.login!!
                user.id = userResponse.id
                user.url = userResponse.url!!
                user.email = userResponse.email!!
                user
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}