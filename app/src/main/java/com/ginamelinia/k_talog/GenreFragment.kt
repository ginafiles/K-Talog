package com.ginamelinia.k_talog

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GenreFragment : Fragment() {
    companion object {
        const val EXTRA_GENRE = "genre"
        const val EXTRA_DRAMA_LIST = "dramaList"
    }

    private lateinit var navController: NavController
    private lateinit var recyclerView: RecyclerView
    private lateinit var toolbar: Toolbar
    private lateinit var toggleButton: ImageButton
    private lateinit var adapter: GenreAdapter
    private var isListLayout = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        toggleButton = view.findViewById(R.id.toggleButton)

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
            val action = GenreFragmentDirections.actionGenreFragmentToDramaFragment()
            action.dramaList = genre.dramaList.toTypedArray()
            findNavController().navigate(action)
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
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            toggleButton.setImageResource(R.drawable.ic_toggle_grid)

        } else {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
            toggleButton.setImageResource(R.drawable.ic_toggle_linear)
        }

        recyclerView.visibility = View.VISIBLE
        adapter.notifyDataSetChanged()
    }

}