package com.pouyaheydari.training.sematec.android.advanced.shahrivar00

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pouyaheydari.training.sematec.android.advanced.shahrivar00.databinding.RecyclerMovieSearchItemBinding

class SearchMovieRecyclerAdapter(val clickListener: (String) -> Unit) :
    ListAdapter<Search, SearchMovieRecyclerAdapter.SearchMovieViewHolder>(MovieDiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMovieViewHolder {
        val binding = RecyclerMovieSearchItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchMovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchMovieViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class SearchMovieViewHolder(val binding: RecyclerMovieSearchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Search) {
            binding.txtMovieTitle.text = item.Title
            binding.imgMoviePoster.loadUrl(item.Poster)
            binding.root.setOnClickListener {
                clickListener(item.Title)
            }
        }
    }
}

class MovieDiffUtils : DiffUtil.ItemCallback<Search>() {
    override fun areItemsTheSame(oldItem: Search, newItem: Search) =
        oldItem.imdbID == newItem.imdbID

    override fun areContentsTheSame(oldItem: Search, newItem: Search) =
        oldItem.Title == newItem.Title && oldItem.Poster == newItem.Poster
}