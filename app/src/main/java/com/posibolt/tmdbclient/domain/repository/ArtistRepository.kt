package com.posibolt.tmdbclient.domain.repository

import com.posibolt.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists() : List<Artist>?
    suspend fun  updateArtists() : List<Artist>?
}