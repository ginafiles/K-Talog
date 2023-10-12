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
            Genre("Slice of Life"),
            Genre("Sageuk (Historical)"),
            Genre("Melodrama"),
            Genre("Romantic Comedy"),
            Genre("Thriller"),
            Genre("Action"),
            Genre("Horror"),
            Genre("Medical"),
            Genre("Law"),
            Genre("Fantasy")
        )

        adapter = GenreAdapter(genres) { genre ->
            val intent = Intent(this, DramaActivity::class.java)

            intent.putExtra(EXTRA_GENRE, genre.name)

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
