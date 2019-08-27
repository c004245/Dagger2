package com.example.moviecheck

import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class ApplicationModule {

    companion object {
        @Singleton
        @Provides
        fun providePicasso(context: Context): Picasso {
            return Picasso.Builder(context).build()
        }
    }
}