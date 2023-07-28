package com.posibolt.tmdbclient.data.repository.tvshow

import android.util.Log
import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.posibolt.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.posibolt.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource

) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
       return getTvShowsFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {
        val newTvShowsLists = getTvShowFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowToDB(newTvShowsLists)
        tvShowCacheDataSource.saveTvShowsToCache(newTvShowsLists)
        return newTvShowsLists
    }

    suspend fun getTvShowFromAPI() : List<TvShow>{
        lateinit var newTvShowList : List<TvShow>
        try {
            var response = tvShowRemoteDataSource.getTvShows()
            var bodys = response.body()
            if (bodys != null) {
                newTvShowList = bodys.tvShows
            }
        }catch (exception : Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        return newTvShowList
    }

    suspend fun getTvShowsFromDB() : List<TvShow>{
        lateinit var newTvShowList : List<TvShow>
        try {
            newTvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (exception : Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        if(newTvShowList.size > 0){
            return newTvShowList
        }else{
            newTvShowList = getTvShowFromAPI()
            tvShowLocalDataSource.saveTvShowToDB(newTvShowList)
        }
        return newTvShowList
    }

    suspend fun getTvShowsFromCache() : List<TvShow>{
        lateinit var newTvShowList : List<TvShow>
        try {
            newTvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception : Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        if(newTvShowList.size>0){
            return newTvShowList
        }else{
            newTvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(newTvShowList)
        }
        return newTvShowList
    }
}