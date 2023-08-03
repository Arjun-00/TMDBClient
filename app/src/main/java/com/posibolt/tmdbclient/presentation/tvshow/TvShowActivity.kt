package com.posibolt.tmdbclient.presentation.tvshow

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
import com.posibolt.tmdbclient.databinding.ActivityTvShowBinding
import com.posibolt.tmdbclient.presentation.di.Injuctor
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var binding : ActivityTvShowBinding
    private lateinit var adapter : TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_show)
        (application as Injuctor).createTvShowSubComponent().inject(this);
        tvShowViewModel = ViewModelProvider(this,factory).get(TvShowViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayPopularTvShow()
    }

    private fun displayPopularTvShow(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responsiveLiveData = tvShowViewModel.getTvShow()
        responsiveLiveData.observe(this, Observer {
            Log.i("MYTAG",it.toString())
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
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
                updateTvShows()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responce = tvShowViewModel.updateTvShow()
        responce.observe(this,Observer{
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvShowProgressBar.visibility = View.GONE
            }else{
                binding.tvShowProgressBar.visibility = View.GONE
            }
        })
    }
}