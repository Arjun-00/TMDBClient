package com.posibolt.tmdbclient.data.api
import com.posibolt.tmdbclient.data.*
import com.posibolt.tmdbclient.data.model.artist.ArtistList
import com.posibolt.tmdbclient.data.model.movie.MovieList
import com.posibolt.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/now_playing")
    suspend fun getPopularMovies(@Query("api_kry")apiKey:String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey: String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key")apiKey: String) : Response<ArtistList>

}