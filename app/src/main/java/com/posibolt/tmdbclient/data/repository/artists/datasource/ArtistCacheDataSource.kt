package com.posibolt.tmdbclient.data.repository.artists.datasource

import com.posibolt.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistFromCache() : List<Artist>
    suspend fun saveArristToCache(artists : List<Artist>)
}