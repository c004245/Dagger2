package com.playgilround.schedule.client.dagger2.di

import com.playgilround.schedule.client.dagger2.presenter.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * @Provide : 모듈 안에서 해당 어노테이션이 달린 메소드 정의
 * 해당 어노테이션이 달린 메서드가 Dagger 가 어떻게 의존성에 맞게
 * 객체를 만들고, 제공하는 지 알려줌.
 *
 * @Module : 모듈들은 의전송을 제공하는 메서드를 가진 클래스
 * 의존성을 제공하는 클래스를 정의하고, @Module 어노테이션을 담.
 * 그러면 Dagger는 클래스 인스턴스 만들 시,
 * 의전송을 만족 시키기 위한 정보를 찾을 수 있음
 */

@Module (includes = [ApiClientModule::class])
class GIthubUserListModule(val view: MainPresenter.View) {

    @Provides
    fun provideMainPresenter(prese)
}
