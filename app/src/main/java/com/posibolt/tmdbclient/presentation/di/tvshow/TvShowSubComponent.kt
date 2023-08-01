package com.posibolt.tmdbclient.presentation.di.tvshow

import com.posibolt.tmdbclient.presentation.artists.ArtistsActivity
import dagger.Subcomponent
@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}