package com.posibolt.tmdbclient.data.repository.artists.datasourceimpl

import com.posibolt.tmdbclient.data.api.TMDBService
import com.posibolt.tmdbclient.data.model.artist.ArtistList
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey: String) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtist(apiKey)
    }

}