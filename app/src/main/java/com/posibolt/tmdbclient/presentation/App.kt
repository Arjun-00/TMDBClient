package com.posibolt.tmdbclient.presentation

import android.app.Application
import com.posibolt.tmdbclient.presentation.di.Injuctor
import com.posibolt.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.posibolt.tmdbclient.presentation.di.core.AppComponent
import com.posibolt.tmdbclient.presentation.di.movie.MovieSubComponent
import com.posibolt.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(),Injuctor {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }
}