package com.posibolt.tmdbclient.domain.usercase

import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.domain.repository.TvShowRepository

class GetTvShowUserCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()
}