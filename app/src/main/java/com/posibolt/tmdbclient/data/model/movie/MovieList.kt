package com.posibolt.tmdbclient.data.model.movie
import com.google.gson.annotations.SerializedName
import com.posibolt.tmdbclient.data.model.movie.Movie

data class MovieList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<Movie>,
)