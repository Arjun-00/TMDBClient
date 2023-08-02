package com.posibolt.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.posibolt.tmdbclient.R
import com.posibolt.tmdbclient.data.model.movie.Movie
import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.databinding.ListItemBinding

class TvShowAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()
    fun setList(tvShow : List<TvShow>){
        tvShowList.clear()
        tvShowList.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, null, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

}


class MyViewHolder(val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(tvShow: TvShow){
        binding.titleTextView.text = tvShow.name
        binding.descriptionTextView.text = tvShow.overview
        val posterUrl = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
        Glide.with(binding.imageView.context).load(posterUrl).into(binding.imageView)
    }
}