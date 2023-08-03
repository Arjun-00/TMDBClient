package com.posibolt.tmdbclient.presentation.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.posibolt.tmdbclient.R
import com.posibolt.tmdbclient.data.model.artist.Artist
import com.posibolt.tmdbclient.data.model.tvshow.TvShow
import com.posibolt.tmdbclient.databinding.ListItemBinding

class ArtistAdapter() : RecyclerView.Adapter<MyViewHolder>() {
    private val ArtistList = ArrayList<Artist>()
    fun setList(artist : List<Artist>){
        ArtistList.clear()
        ArtistList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, null, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ArtistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(ArtistList[position])
    }

}

class MyViewHolder(val binding : ListItemBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(artist: Artist){
        binding.titleTextView.text = artist.name
        binding.descriptionTextView.text = artist.popularity.toString()
        val posterUrl = "https://image.tmdb.org/t/p/w500"+artist.profilePath
        Glide.with(binding.imageView.context).load(posterUrl).into(binding.imageView)
    }
}