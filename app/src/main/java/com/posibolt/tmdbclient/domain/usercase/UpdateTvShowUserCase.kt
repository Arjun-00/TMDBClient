package com.posibolt.tmdbclient.domain.usercase

import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUserCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute() : List<TvShow>? = tvShowRepository.updateTvShow()
}