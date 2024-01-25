package com.example.t9a1_lagardera_carles.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t9a1_lagardera_carles.R
import com.example.t9a1_lagardera_carles.databinding.ItemLavadosBinding
import com.example.t9a1_lagardera_carles.entities.LavadoCoche

class LavadoAdapter(
    private var lavados: MutableList<LavadoCoche>,
    private var listener: onClickListener
) : RecyclerView.Adapter<LavadoAdapter.ViewHolder>() {


    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_lavados, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lavado = lavados.get(position)

        with(holder) {
            setListener(lavado)
            binding.imgRaqueta.setImageResource(R.drawable.berlina)
            binding.txtMarca.text = "Marca: ${lavado.marca}"
            binding.txtModelo.text = "Modelo: ${lavado.modelo}"
            binding.txtDireccion.text = "Dirección:  ${lavado.direccion}"
        }

    }

    fun add(lavado: LavadoCoche) {
        lavados.add(lavado)
        notifyDataSetChanged()
    }

    fun update(lavado: LavadoCoche) {
        val index = lavados.indexOf(lavado)
        if (index != -1) {
            lavados.set(index, lavado)
            notifyItemChanged(index)
        }
    }

    fun delete(lavado: LavadoCoche) {
        val index = lavados.indexOf(lavado)
        if (index != -1) {
            lavados.removeAt(index)
            notifyItemRemoved(index)
        }
    }


    override fun getItemCount(): Int = lavados.size
    fun setLavados(lavado: MutableList<LavadoCoche>) {
        this.lavados = lavado
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLavadosBinding.bind(view)

        fun setListener(lavado: LavadoCoche) {

            with(binding.root) {
                setOnClickListener {
                    listener.onClick(lavado)
                }
                setOnLongClickListener {
                    listener.onDeleteLavado(lavado)
                    true
                }
            }

            binding.cbfavourite.setOnClickListener {
                listener.onFavouriteLavado(lavado)
            }
        }
    }
}