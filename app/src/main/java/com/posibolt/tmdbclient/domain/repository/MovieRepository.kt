package com.posibolt.tmdbclient.domain.repository

import com.posibolt.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?
}