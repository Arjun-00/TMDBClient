package com.posibolt.tmdbclient.presentation.di.core

import com.posibolt.tmdbclient.data.repository.artists.ArtistRepositoryImpl
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.posibolt.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.posibolt.tmdbclient.domain.repository.ArtistRepository
import com.posibolt.tmdbclient.domain.repository.MovieRepository
import com.posibolt.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{
        return MovieRepositoryImpl(
            movieCacheDataSource,
            movieLocalDataSource,
            movieRemoteDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
       artistLocalDataSource: ArtistLocalDataSource,
       artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository{
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowCacheDataSource: TvShowCacheDataSource,
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource
    ) : TvShowRepository{
        return TvShowRepositoryImpl(
           tvShowCacheDataSource,tvShowRemoteDataSource,tvShowLocalDataSource
        )
    }

}