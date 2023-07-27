package com.posibolt.tmdbclient.domain.usercase

import com.posibolt.tmdbclient.data.model.artist.Artist
import com.posibolt.tmdbclient.domain.repository.ArtistRepository

class GetArtistUserCase(private val artistRepository: ArtistRepository) {

    suspend fun execute() : List<Artist>? = artistRepository.getArtists()
}