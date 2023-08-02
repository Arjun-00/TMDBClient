package com.posibolt.tmdbclient.presentation.di.tvshow

import com.posibolt.tmdbclient.presentation.artists.ArtistsActivity
import com.posibolt.tmdbclient.presentation.tvshow.TvShowActivity
import dagger.Subcomponent
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}