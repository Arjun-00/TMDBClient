package com.posibolt.tmdbclient.data.repository.movie

import android.util.Log
import com.posibolt.tmdbclient.data.model.movie.Movie
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.posibolt.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.posibolt.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieRemoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
       return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI() : List<Movie>{
        lateinit var movieList : List<Movie>
        try{
            val responce = movieRemoteDataSource.getMovies()
            val body = responce.body()
            if(body !=null){
                movieList = body.movies
            }
        }catch (exception:Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie>{
        lateinit var movieList : List<Movie>
        try{
            movieList = movieLocalDataSource.getMovieFromDB()
        }catch (exception : Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        if(movieList.size > 0){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDB(movieList)

        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList : List<Movie>
        try{
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (exception : Exception){
            Log.i("MYTAG",exception.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }

}