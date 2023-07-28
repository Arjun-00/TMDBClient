package com.posibolt.tmdbclient.data.repository.artists.datasourceimpl

import com.posibolt.tmdbclient.data.model.artist.Artist
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl : ArtistCacheDataSource {
    private var  artistsList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
       return artistsList
    }

    override suspend fun saveArristToCache(artists: List<Artist>) {
        artistsList.clear()
        artistsList = ArrayList(artists)
    }
}