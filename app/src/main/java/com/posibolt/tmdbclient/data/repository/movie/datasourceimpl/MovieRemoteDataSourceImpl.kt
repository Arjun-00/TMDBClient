package com.posibolt.tmdbclient.data.repository.movie.datasourceimpl

import com.posibolt.tmdbclient.data.api.TMDBService
import com.posibolt.tmdbclient.data.model.movie.MovieList
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdbService: TMDBService,private val apiKey: String) :
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}