package com.posibolt.tmdbclient.presentation

import android.app.Application
import com.posibolt.tmdbclient.BuildConfig
import com.posibolt.tmdbclient.presentation.di.Injuctor
import com.posibolt.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.posibolt.tmdbclient.presentation.di.core.*
import com.posibolt.tmdbclient.presentation.di.movie.MovieSubComponent
import com.posibolt.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App : Application(),Injuctor {

    private lateinit var appComponent : AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(applicationContext)).netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY)).build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}