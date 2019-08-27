package com.example.moviecheck

import androidx.recyclerview.widget.RecyclerView
import com.example.moviecheck.di.ActivityScoped
import com.example.moviecheck.di.FragmentScoped
import com.example.moviecheck.model.Movie
import com.example.moviecheck.model.MovieApi
import com.example.moviecheck.source.MovieRemoteDataSource
import com.example.moviecheck.view.MainFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import com.example.moviecheck.source.DataSource
import retrofit2.create


@Module
abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun provideMainFragment(): MainFragment

    @ActivityScoped
    @Binds
    abstract fun provideMainPresenter(mainPresenter: MainPresenter)

    @ActivityScoped
    @Binds
    abstract fun provideMainAdapter(mainAdapter: MainAdapter): RecyclerView.Adapter<MainAdapter.MainViewHolder>

    @ActivityScoped
    @Binds
    abstract fun provideMovieDataSource(movieRemoteDataSource: MovieRemoteDataSource): DataSource<Movie>


    companion object {
        @ActivityScoped
        @Provides
        fun provideMovieApi(retrofit: Retrofit): MovieApi {
            return retrofit.create(MovieApi::class.java)
        }
    }
}