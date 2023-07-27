package com.posibolt.tmdbclient.domain.usercase

import com.posibolt.tmdbclient.data.model.movie.Movie
import com.posibolt.tmdbclient.domain.repository.MovieRepository

class GetMovieUserCase(private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.getMovies()
}