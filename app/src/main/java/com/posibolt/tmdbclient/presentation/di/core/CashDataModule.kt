package com.posibolt.tmdbclient.presentation.di.core

import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasourceimpl.ArtistCacheDataSourceImpl
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CashDataModule {
    @Singleton
    @Provides
    fun ProviderMovieCashDataSource() : MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCashDataSource() : ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
    @Singleton
    @Provides
    fun providerTvShowCashDataSource() : TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }
}