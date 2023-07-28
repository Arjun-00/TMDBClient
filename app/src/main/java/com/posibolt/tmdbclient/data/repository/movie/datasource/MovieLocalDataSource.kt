package com.posibolt.tmdbclient.data.repository.movie.datasource

import com.posibolt.tmdbclient.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMovieFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}