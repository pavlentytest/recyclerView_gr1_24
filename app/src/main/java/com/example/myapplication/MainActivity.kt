package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder


data class Book(val name: String, val year: String, val image: String)

class MainActivity : AppCompatActivity() {

    lateinit var books: List<Book>
    lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.recyclerView)
        val result = application.assets.open("books.js").bufferedReader().use { it.readText() }
        val gson = GsonBuilder().create()
        books = gson.fromJson(result,Array<Book>::class.java).toList()
        rv.adapter = MyAdapter(books)
        rv.layoutManager = LinearLayoutManager(this)
    }
}