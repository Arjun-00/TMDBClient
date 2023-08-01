package com.posibolt.tmdbclient.presentation.di.movie

import com.posibolt.tmdbclient.presentation.artists.ArtistsActivity
import com.posibolt.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent
@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}