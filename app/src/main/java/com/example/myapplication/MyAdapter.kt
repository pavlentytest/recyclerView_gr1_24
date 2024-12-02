package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class MyAdapter(val list: List<Book>) : RecyclerView.Adapter<MyAdapter.MyItemView>() {

    class MyItemView(view: View) : RecyclerView.ViewHolder(view) {
        val bookName: TextView = view.findViewById(R.id.textView)
        val bookYear: TextView = view.findViewById(R.id.textView2)
        val bookImage: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item,parent,false)
        return MyItemView(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyItemView, position: Int) {
        holder.bookName.text = list.get(position).name
        holder.bookYear.text = list.get(position).year
        Picasso.get().load(list.get(position).image).into(holder.bookImage)
        holder.itemView.setOnClickListener {
            Snackbar.make(holder.itemView.rootView, "Position $position", Snackbar.LENGTH_LONG).show()
        }
    }

}