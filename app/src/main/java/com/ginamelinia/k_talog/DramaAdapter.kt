package com.ginamelinia.k_talog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class DramaAdapter(private val dramaList: ArrayList<String>) : RecyclerView.Adapter<DramaAdapter.DramaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DramaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_drama, parent, false)
        return DramaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DramaViewHolder, position: Int) {
        val drama = dramaList[position]
        holder.bind(drama)
    }

    override fun getItemCount() = dramaList.size

    inner class DramaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btnDrama: MaterialButton = itemView.findViewById(R.id.dramaButton)

        fun bind(drama: String) {
            btnDrama.text = drama
        }
    }
}
