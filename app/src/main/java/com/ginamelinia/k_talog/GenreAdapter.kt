package com.ginamelinia.k_talog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class GenreAdapter(
    private val genres: List<Genre>,
    private val onItemClick: (Genre) -> Unit) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = genres[position]
        holder.bind(genre)
    }

    override fun getItemCount() = genres.size

    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val genreButton: MaterialButton = itemView.findViewById(R.id.genreButton)

        fun bind(genre: Genre) {
            genreButton.text = genre.name
            genreButton.setOnClickListener{
                onItemClick(genre)
            }
        }
    }
}
