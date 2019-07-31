package com.playgilround.schedule.client.dagger2.presenter

import android.annotation.SuppressLint
import com.playgilround.schedule.client.dagger2.api.GithubUserApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*
* 여기에서 @inject가 constructor 앞에 있는 것은, 생성자가 클래스 생성 중에 모든 매개 변수 의존성을 모으도록 Dagger에 지시합니다.
* 생성자가 @inject 되었기 때문에 Dagger를 통해 MainPresenter 의존성을 가져옵니다.
*/
class MainPresenter @Inject constructor(val view: MainContract.View, val client: GithubUserApiClient): MainContract.Presenter {
    val mCompositeDisposable = CompositeDisposable()

    override fun unsubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear()
        }
    }

    @SuppressLint("CheckResult")
    override fun getGithubUserList(q: String) {
        val disposable = client.userDataService.getUserData(q, "repositories", "desc")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.onDataLoaded(it)
            }, {view.onDataFailed()}, {})

        mCompositeDisposable.add(disposable)
    }
}