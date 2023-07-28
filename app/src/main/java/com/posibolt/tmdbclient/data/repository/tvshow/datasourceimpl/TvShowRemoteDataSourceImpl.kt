package com.posibolt.tmdbclient.data.repository.tvshow.datasourceimpl

import com.posibolt.tmdbclient.data.api.TMDBService
import com.posibolt.tmdbclient.data.model.tvshow.TvShowList
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey:String) : TvShowRemoteDataSource {
    override
    suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}