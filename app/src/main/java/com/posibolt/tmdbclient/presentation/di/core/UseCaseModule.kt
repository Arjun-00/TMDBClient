package com.posibolt.tmdbclient.presentation.di.core

import com.posibolt.tmdbclient.domain.repository.ArtistRepository
import com.posibolt.tmdbclient.domain.repository.MovieRepository
import com.posibolt.tmdbclient.domain.repository.TvShowRepository
import com.posibolt.tmdbclient.domain.usercase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUserCase(movieRepository: MovieRepository) : GetMovieUserCase{
        return GetMovieUserCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUserCase(movieRepository: MovieRepository) : UpdateMovieUserCase{
        return UpdateMovieUserCase(
            movieRepository)
    }

    @Provides
    fun provideGetArtistUserCase(artistRepository: ArtistRepository) : GetArtistUserCase{
        return GetArtistUserCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUserCase(artistRepository: ArtistRepository) : UpdateArtistUserCase{
        return UpdateArtistUserCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUserCase(tvShowRepository: TvShowRepository) : GetTvShowUserCase{
        return GetTvShowUserCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUserCase(tvShowRepository: TvShowRepository) : UpdateTvShowUserCase{
        return UpdateTvShowUserCase(tvShowRepository)
    }

}