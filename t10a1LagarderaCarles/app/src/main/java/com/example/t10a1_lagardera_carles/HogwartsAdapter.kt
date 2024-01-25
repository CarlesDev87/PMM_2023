package com.example.t10a1_lagardera_carles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class HogwartsAdapter(val personajes: List<String>) : RecyclerView.Adapter<HogwartsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HogwartsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HogwartsViewHolder(layoutInflater.inflate(R.layout.item_hogwarts, parent, false))

    }

    override fun getItemCount(): Int = personajes.size

    override fun onBindViewHolder(holder: HogwartsViewHolder, position: Int) {
        val item = personajes[position]
        holder.bind(item)
    }


}