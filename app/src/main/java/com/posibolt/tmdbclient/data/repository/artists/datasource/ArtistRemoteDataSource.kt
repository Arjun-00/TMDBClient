package com.posibolt.tmdbclient.data.repository.artists.datasource
import com.posibolt.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists() : Response<ArtistList>
}