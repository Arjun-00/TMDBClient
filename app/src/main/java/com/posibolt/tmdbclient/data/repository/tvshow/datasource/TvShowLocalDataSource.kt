package com.posibolt.tmdbclient.data.repository.tvshow.datasource

import com.posibolt.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDataSource {

    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowToDB(tvShows : List<TvShow>)
    suspend fun clearAll()
}