package com.ginamelinia.k_talog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_GENRE = "genre"
        const val EXTRA_DRAMA_LIST = "dramaList"
    }
    private lateinit var recyclerView: RecyclerView
    private lateinit var toggleButton: Button
    private lateinit var adapter: GenreAdapter
    private var isListLayout = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        toggleButton = findViewById(R.id.toggleButton)

        val genres = listOf(
            Genre("Slice of Life", listOf("Reply 1988", "My Mister", "When the Camelia Blooms")) ,
            Genre("Sageuk (Historical)", listOf("Moon Lovers: Scarlet Heart Ryeo", "The Red Sleeve", "Moonlight Drawn by Clouds")),
            Genre("Melodrama", listOf("Chocolate", "Encounter", "Now, We Are Breaking Up")),
            Genre("Romantic Comedy", listOf("Fight for My Way", "Strong Woman Do Bong Soon", "Business Proposal")),
            Genre("Thriller", listOf("Voice", "Signal", "Tunnel")),
            Genre("Action", listOf("The K2", "Vincenzo", "Vagabond")),
            Genre("Horror", listOf("Revenant", "Kingdom", "Let's Fight Ghost")),
            Genre("Medical", listOf("Good Doctor", "Hospital Playlist", "Romantic Doctor Teacher Kim")),
            Genre("Law", listOf("Extraordinary Attorney Woo", "Partners for Justice", "Law School")),
            Genre("Fantasy", listOf("My Love from the Star", "Goblin", "Hotel Del Luna"))
        )

        adapter = GenreAdapter(genres) { genre ->
            val intent = Intent(this, DramaActivity::class.java)
            intent.putExtra(EXTRA_GENRE, genre.name)
                .putStringArrayListExtra(EXTRA_DRAMA_LIST, ArrayList(genre.dramaList))

            startActivity(intent)
        }
        recyclerView.adapter = adapter

        toggleButton.setOnClickListener {
            isListLayout = !isListLayout
            updateLayout()
        }

        updateLayout()
    }

    private fun updateLayout() {
        if (isListLayout) {
            recyclerView.layoutManager = LinearLayoutManager(this)
            toggleButton.text = "Grid View"
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            toggleButton.text = "List View"
        }

        recyclerView.visibility = View.VISIBLE
        adapter.notifyDataSetChanged()
    }
}
