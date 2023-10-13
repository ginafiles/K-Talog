package com.ginamelinia.k_talog

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DramaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var dramaButton: ArrayList<String>? = null
    private lateinit var textIntent: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drama)

        textIntent = findViewById(R.id.textGenre)
        recyclerView = findViewById(R.id.recyclerView2)
        recyclerView.layoutManager = LinearLayoutManager(this)


        val string = intent?.getStringExtra(MainActivity.EXTRA_GENRE)
        val arrayList = intent?.getStringArrayListExtra(MainActivity.EXTRA_DRAMA_LIST)

        textIntent?.text = string
        dramaButton = arrayList

        val adapter = DramaAdapter(dramaButton!!)
        recyclerView.adapter = adapter
    }
}