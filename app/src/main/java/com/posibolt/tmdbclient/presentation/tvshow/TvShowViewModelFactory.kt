package com.posibolt.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.posibolt.tmdbclient.domain.usercase.GetTvShowUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateTvShowUserCase

class TvShowViewModelFactory(
    private val getTvShowUserCase: GetTvShowUserCase,
    private val updateTvShowUserCase: UpdateTvShowUserCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUserCase,updateTvShowUserCase) as T
    }
}