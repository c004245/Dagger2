package com.example.repositoryuser.module

import android.app.Application
import com.example.repositoryuser.BuildConfig
import com.example.repositoryuser.R
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class GithubApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }

        builder.connectTimeout(60 * 1000, TimeUnit.MILLISECONDS)
            .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRestAdapter(application: Application, okHttpClient: OkHttpClient): Retrofit {
        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
            .baseUrl(application.getString(R.string.base_url))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())

        return builder.build()
    }
}