package com.posibolt.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.posibolt.tmdbclient.domain.usercase.GetTvShowUserCase
import com.posibolt.tmdbclient.domain.usercase.UpdateTvShowUserCase

class TvShowViewModel(
    private val getTvShowUserCase: GetTvShowUserCase,
    private val updateTvShowUserCase: UpdateTvShowUserCase
) : ViewModel(){

    fun getTvShow() = liveData {
        val tvShowList = getTvShowUserCase.execute()
        emit(tvShowList)
    }

    fun updateTvShow() = liveData {
        val tvShowList = updateTvShowUserCase.execute()
        emit(tvShowList)
    }
}