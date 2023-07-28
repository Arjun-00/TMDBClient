package com.posibolt.tmdbclient.data.repository.tvshow.datasourceimpl

import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var newTvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return newTvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
       newTvShowsList.clear()
        newTvShowsList = ArrayList(tvShows)
    }
}