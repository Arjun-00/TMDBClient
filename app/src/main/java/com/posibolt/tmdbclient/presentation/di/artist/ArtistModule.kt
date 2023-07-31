package com.posibolt.tmdbclient.presentation.di.artist

import com.posibolt.tmdbclient.domain.usercase.GetArtistUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateArtistUserCase
import com.posibolt.tmdbclient.presentation.artists.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule{
    @AristScope
    @Provides
    fun provideArtistViewModelFactory(getArtistUserCase: GetArtistUserCase,updateArtistUserCase: UpdateArtistUserCase)
    :ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUserCase,updateArtistUserCase)
    }
}