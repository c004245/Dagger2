package com.example.moviecheck

import android.graphics.Movie
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecheck.view.MainFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import javax.sql.DataSource

@Module
open class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    open fun provideMainFragment(): MainFragment {}

    @ActivityScoped
    @Binds
    open fun provideMainPresenter(mainPresenter: MainPresenter) {

    }

    @ActivityScoped
    @Binds
    open fun provideMainAdapter(mainAdapter: MainAdapter): RecyclerView.Adapter<MainAdapter.ViewHolder> {

    }

    @ActivityScoped
    @Binds
    open fun provideMovieDataSource(movieRemoteDataSource: MovieRemoteDataSource): DataSource<Movie> {

    }


    companion object {
        @ActivityScoped
        @Provides
        fun provideMovidApi(retrofit: Retrofit): MediaRemoteDataSource.MovieApi {
            return retrofit.create(MovieRemoteDataSource.MovieApi.class)
        }
    }
}