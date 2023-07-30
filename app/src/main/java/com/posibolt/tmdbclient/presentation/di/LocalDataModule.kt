package com.posibolt.tmdbclient.presentation.di

import com.posibolt.tmdbclient.data.db.ArtistDao
import com.posibolt.tmdbclient.data.db.MovieDao
import com.posibolt.tmdbclient.data.db.TvShowDao
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasourceimpl.ArtistLocalDataSourceImpl
import com.posibolt.tmdbclient.data.repository.artists.datasourceimpl.ArtistRemoteDataSourceImpl
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasourceimpl.MovieLocalDataSourceImpl
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource{
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }
}