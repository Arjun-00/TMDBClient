package com.posibolt.tmdbclient.data.repository.artists.datasource

import com.posibolt.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistFromDB() : List<Artist>
    suspend fun saveArtistToDB(artists : List<Artist>)
    suspend fun crearAll()
}