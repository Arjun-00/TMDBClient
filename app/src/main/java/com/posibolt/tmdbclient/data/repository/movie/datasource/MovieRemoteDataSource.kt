package com.posibolt.tmdbclient.data.repository.movie.datasource
import com.posibolt.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies() : Response<MovieList>
}