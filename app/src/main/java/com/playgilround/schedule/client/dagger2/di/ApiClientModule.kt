package com.playgilround.schedule.client.dagger2.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

/**
 * @Provides : 모듈 안에서 해당 어느테이션이 달린 메서드 정의
 * 해당 어노테이션이 달린 메서드가 Dagger 가 어떻게 의존성에 맞게
 * 객체를 만들고 제공하는지 알려줌
 *
 * @Module : 모듈들은 의존성을 제공하는 메서드를 가진 클래스
 * 의존성을 제공하는 클래스를 정의하고, @Module 어노테이션을 답니다.
 * 그러면 Dagger 는 클래스 인스턴스를 만들 때에 의존성을
 * 만족시키기 위한 정보를 찾을 수 있음
 */

@Module
class ApiClientModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .build();
    }
}
