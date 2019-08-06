package com.example.repositoryuser.splash

import com.example.repositoryuser.data.UserManager
import com.example.repositoryuser.model.User
import com.example.repositoryuser.util.SimpleObserver
import com.example.repositoryuser.util.Validator

class SplashActivityPresenter constructor(private var splashActivity: SplashActivity, private var validator: Validator,
                                          private var userManager: UserManager) {

    private var username: String
    fun onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true)
            userManager.getUser(username).subscribe(SimpleObserver<User>() {
                fun onNext(user: User) {
                    splashActivity.showLoading
                }


            })

        }
    }


}