package com.posibolt.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.posibolt.tmdbclient.domain.usercase.GetArtistUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateArtistUserCase

class ArtistViewModelFactory(
    private val getArtistUserCase: GetArtistUserCase,
    private val updateArtistUserCase: UpdateArtistUserCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistUserCase, updateArtistUserCase) as T
    }
}