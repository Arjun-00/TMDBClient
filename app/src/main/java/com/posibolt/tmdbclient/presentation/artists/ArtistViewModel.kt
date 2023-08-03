package com.posibolt.tmdbclient.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.posibolt.tmdbclient.domain.usercase.GetArtistUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateArtistUserCase

class ArtistViewModel(
    private val getArtistUserCase: GetArtistUserCase,
    private val updateArtistUserCase: UpdateArtistUserCase
) : ViewModel() {

    fun getArtist() = liveData {
        val artistList = getArtistUserCase.execute()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistUserCase.execute()
        emit(artistList)
    }

}