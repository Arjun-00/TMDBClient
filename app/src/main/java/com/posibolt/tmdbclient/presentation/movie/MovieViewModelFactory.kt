package com.posibolt.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.posibolt.tmdbclient.domain.usercase.GetMovieUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateMovieUserCase

class MovieViewModelFactory(
    private val getMovieUserCase: GetMovieUserCase,
    private val updateMovieUserCase: UpdateMovieUserCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUserCase,updateMovieUserCase) as T
    }
}