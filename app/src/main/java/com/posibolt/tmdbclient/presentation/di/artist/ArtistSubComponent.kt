package com.posibolt.tmdbclient.presentation.di.artist

import com.posibolt.tmdbclient.presentation.artists.ArtistsActivity
import dagger.Subcomponent
@AristScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}