package com.ginamelinia.k_talog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DramaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DramaAdapter
    private var dramaButton: ArrayList<String>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drama, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView2)

        var dramaList = arguments?.getStringArray(GenreFragment.EXTRA_DRAMA_LIST)

        if (dramaList != null) {
            adapter = DramaAdapter(dramaList.toList())
        }
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
