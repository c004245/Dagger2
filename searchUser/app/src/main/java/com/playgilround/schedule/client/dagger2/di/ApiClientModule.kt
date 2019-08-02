package com.playgilround.schedule.client.dagger2.di

import com.playgilround.schedule.client.dagger2.api.GithubUserApiClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/*
 * @Provides : 모듈 안에서 해당 어노테이션이 달린 메서드 정의
 * Dagger가 어떻게 의존성에 맞게 객체를 만들고 제공하는지 알려줌
 *
 * @Module : 모듈들은 의존성을 제공하는 메서드들을 가진 클래스
 * 의존성을 제공하는 클래스를 정의
 * Dagger는 클래스 인스턴스를 만들 때 의존성을 만족 시키기 위한 정보를 찾을 수 있음
 */

@Module
class ApiClientModule {
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    fun provideGithubUserApiClient(): GithubUserApiClient {
        return GithubUserApiClient(provideOkHttpClient())
    }
}