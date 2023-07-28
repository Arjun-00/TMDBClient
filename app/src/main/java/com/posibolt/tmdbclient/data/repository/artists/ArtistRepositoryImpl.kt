package com.posibolt.tmdbclient.data.repository.artists

import android.util.Log
import com.posibolt.tmdbclient.data.model.artist.Artist
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistCacheDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistLocalDataSource
import com.posibolt.tmdbclient.data.repository.artists.datasource.ArtistRemoteDataSource
import com.posibolt.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newAListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.crearAll()
        artistLocalDataSource.saveArtistToDB(newAListOfArtists)
        artistCacheDataSource.saveArristToCache(newAListOfArtists)
        return newAListOfArtists
    }

    suspend fun getArtistsFromAPI() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            var response = artistRemoteDataSource.getArtists()
            var body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        }catch(exception :Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB() : List<Artist>{
        lateinit var artistList : List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (exception:Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        if(artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistsFromCache() : List<Artist>{
        lateinit var artistList : List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistFromCache()
        }catch (exception:Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArristToCache(artistList)
        }
        return artistList

    }
}