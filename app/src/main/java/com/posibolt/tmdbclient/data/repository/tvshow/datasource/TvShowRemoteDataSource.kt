package com.posibolt.tmdbclient.data.repository.tvshow.datasource

import com.posibolt.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows() : Response<TvShowList>
}