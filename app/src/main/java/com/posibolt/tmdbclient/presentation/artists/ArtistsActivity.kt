package com.posibolt.tmdbclient.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.posibolt.tmdbclient.R
import com.posibolt.tmdbclient.databinding.ActivityArtistsBinding
import com.posibolt.tmdbclient.databinding.ActivityHomeBinding

class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)
    }
}