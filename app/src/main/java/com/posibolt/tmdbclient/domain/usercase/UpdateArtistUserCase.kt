package com.posibolt.tmdbclient.domain.usercase

import com.posibolt.tmdbclient.data.model.artist.Artist
import com.posibolt.tmdbclient.domain.repository.ArtistRepository

class UpdateArtistUserCase(private val artistRepository: ArtistRepository) {

    suspend fun execute() : List<Artist>? = artistRepository.updateArtists()
}