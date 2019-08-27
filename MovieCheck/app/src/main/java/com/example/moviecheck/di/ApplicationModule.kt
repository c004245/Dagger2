package com.example.moviecheck.di

import android.app.Application
import android.content.Context
import com.example.moviecheck.BuildConfig
import com.squareup.picasso.Picasso
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    companion object {

        @Singleton
        @Provides
        fun providePicasso(context: Context): Picasso {
            return Picasso.Builder(context).build()
        }

        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()
        }
    }

    @Singleton
    @Binds
    abstract fun bindContext(application: Application): Context
}