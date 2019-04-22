package com.playgilround.schedule.client.dagger2.presenter

import android.annotation.SuppressLint
import javax.inject.Inject

/**
 * @inject 가 constructor 앞에 있는 경우,
 * 생성자가 클래스 생성 중에 모든 매게 변수 의존성을 모으도록 Dagger 에 지시
 * 생성자가 @Inject 되었기에, Dagger를 통해 MainPresenterImpl 의존성을 가져옴
 */

class MainPresenterImpl @Inject constructor(val view: MainPresenter.View, val client: GithubUserApiClient) : MainPresenter {

    @SuppressLint("CheckResult")
    override fun getGithubUserList(q: String) {

    }
}