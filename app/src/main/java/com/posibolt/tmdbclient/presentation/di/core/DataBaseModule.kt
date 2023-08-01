package com.posibolt.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.posibolt.tmdbclient.data.db.ArtistDao
import com.posibolt.tmdbclient.data.db.MovieDao
import com.posibolt.tmdbclient.data.db.TMDBDatabase
import com.posibolt.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context) : TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbclient").build()
    }

    @Singleton
    @Provides
    fun provderMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun providerArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }
    @Singleton
    @Provides
    fun providerTvShowDao(tmdbDatabase: TMDBDatabase) : TvShowDao{
        return tmdbDatabase.tvShowDao()
    }

}