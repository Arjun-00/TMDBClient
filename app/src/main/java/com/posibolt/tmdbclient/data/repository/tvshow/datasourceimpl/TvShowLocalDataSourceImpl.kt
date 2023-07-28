package com.posibolt.tmdbclient.data.repository.tvshow.datasourceimpl

import com.posibolt.tmdbclient.data.db.TvShowDao
import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowToDB(tvShows: List<TvShow>) {
       CoroutineScope(Dispatchers.IO).launch {
           tvShowDao.saveTvShows(tvShows)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            tvShowDao.deleteAllTvShows()
        }
    }
}