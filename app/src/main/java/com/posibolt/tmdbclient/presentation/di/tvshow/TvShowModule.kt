package com.posibolt.tmdbclient.presentation.di.tvshow

import com.posibolt.tmdbclient.domain.usercase.GetTvShowUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateTvShowUserCase
import com.posibolt.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule{
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(getTvShowUserCase: GetTvShowUserCase,updateTvShowUserCase: UpdateTvShowUserCase)
    : TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowUserCase,updateTvShowUserCase)
    }
}