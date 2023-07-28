package com.posibolt.tmdbclient.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.posibolt.tmdbclient.R
import com.posibolt.tmdbclient.databinding.ActivityHomeBinding
import com.posibolt.tmdbclient.presentation.artists.ArtistsActivity
import com.posibolt.tmdbclient.presentation.movie.MovieActivity
import com.posibolt.tmdbclient.presentation.tvshow.TvShowActivity

//For API reg https://www.themoviedb.org/
class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.movieButton.setOnClickListener {
            val intent = Intent(this,MovieActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this,ArtistsActivity::class.java)
            startActivity(intent)
        }

        binding.tvshowButton.setOnClickListener {
            val intent = Intent(this,TvShowActivity::class.java)
            startActivity(intent)
        }
    }
}