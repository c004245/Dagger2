package com.playgilround.schedule.client.dagger2.di

import com.playgilround.schedule.client.dagger2.presenter.MainContract
import com.playgilround.schedule.client.dagger2.presenter.MainPresenter
import dagger.Module
import dagger.Provides

@Module(includes = [ApiClientModule::class])
class GithubUserListModule(val view: MainContract.View) {

    @Provides
    fun provideMainPresenter(presenter: MainPresenter) : MainContract.Presenter {
        return presenter
    }

    @Provides
    fun provideMainView(): MainContract.View {
        return view
    }
}