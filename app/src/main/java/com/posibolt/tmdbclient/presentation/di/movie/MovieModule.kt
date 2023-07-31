package com.posibolt.tmdbclient.presentation.di.movie

import com.posibolt.tmdbclient.domain.usercase.GetArtistUserCase
import com.posibolt.tmdbclient.domain.usercase.GetMovieUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateArtistUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateMovieUserCase
import com.posibolt.tmdbclient.presentation.artists.ArtistViewModelFactory
import com.posibolt.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule{
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(getMovieUserCase: GetMovieUserCase,updateMovieUserCase: UpdateMovieUserCase)
    :MovieViewModelFactory{
        return MovieViewModelFactory(getMovieUserCase,updateMovieUserCase)
    }
}