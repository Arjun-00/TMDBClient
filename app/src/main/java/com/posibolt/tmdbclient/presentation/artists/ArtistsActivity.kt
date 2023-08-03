package com.posibolt.tmdbclient.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.posibolt.tmdbclient.R
import com.posibolt.tmdbclient.databinding.ActivityArtistsBinding
import com.posibolt.tmdbclient.presentation.di.Injuctor
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory : ArtistViewModelFactory
    private lateinit var artistViewModel : ArtistViewModel
    private lateinit var adapter : ArtistAdapter
    private lateinit var binding : ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)
        (application as Injuctor).createArtistSubComponent().inject(this)
        artistViewModel = ViewModelProvider(this,factory).get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtist()
    }

    private fun displayPopularArtist(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responsiveLiveData = artistViewModel.getArtist()
        responsiveLiveData.observe(this, Observer {
            Log.i("MYTAG",it.toString())
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                Toast.makeText(this,"NO Data Avilable", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflator : MenuInflater = menuInflater
        inflator.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update -> {
                updateArtist()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtist(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responce = artistViewModel.updateArtist()
        responce.observe(this,Observer{
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
            }
        })
    }
}