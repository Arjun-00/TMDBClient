package com.posibolt.tmdbclient.presentation.movie
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.posibolt.tmdbclient.domain.usercase.GetMovieUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateMovieUserCase

class MovieViewModel(
    private val getMovieUserCase: GetMovieUserCase,
    private val updateMovieUserCase: UpdateMovieUserCase
) : ViewModel() {

    fun getMovies() = liveData {
        val movieList = getMovieUserCase.execute()
        emit(movieList)
    }

    fun upDateMovies() = liveData {
        val movieList = updateMovieUserCase.execute()
        emit(movieList)
    }
}