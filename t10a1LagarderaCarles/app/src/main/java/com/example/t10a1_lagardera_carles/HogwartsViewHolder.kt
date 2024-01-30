package com.example.t10a1_lagardera_carles

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t10a1_lagardera_carles.databinding.ItemHogwartsBinding
import com.squareup.picasso.Picasso

class HogwartsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemHogwartsBinding.bind(view)
    fun bind(personaje: HogwartsResponse) {
        Picasso.get().load(personaje.url).into(binding.img)
        binding.txtNombre.text = personaje.nombre
        binding.txtEspecie.text = personaje.especie
        binding.txtPatronus.text = personaje.patrono

    }
}