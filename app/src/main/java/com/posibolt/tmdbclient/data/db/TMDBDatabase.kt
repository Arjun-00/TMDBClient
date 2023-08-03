package com.posibolt.tmdbclient.data.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.posibolt.tmdbclient.data.model.artist.Artist
import com.posibolt.tmdbclient.data.model.movie.Movie
import com.posibolt.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
    abstract fun artistDao() : ArtistDao
    abstract fun tvShowDao() : TvShowDao

    companion object {
        @Volatile
        private var INSTANCE: TMDBDatabase? = null
        fun getInstance(context: Context): TMDBDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TMDBDatabase::class.java,
                        "subscribe_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}