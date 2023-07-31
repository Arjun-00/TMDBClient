package com.posibolt.tmdbclient.presentation.di

import com.posibolt.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.posibolt.tmdbclient.presentation.di.movie.MovieSubComponent
import com.posibolt.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injuctor {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
}