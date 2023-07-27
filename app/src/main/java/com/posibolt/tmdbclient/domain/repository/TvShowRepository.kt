package com.posibolt.tmdbclient.domain.repository

import com.posibolt.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows() : List<TvShow>?
    suspend fun  updateTvShow() : List<TvShow>?
}