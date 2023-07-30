package com.posibolt.tmdbclient.presentation.di

import com.posibolt.tmdbclient.data.api.TMDBService
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasourceimpl.ArtistRemoteDataSourceImpl
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmdbService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmdbService,apiKey)
    }

}