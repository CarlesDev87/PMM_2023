package com.example.banco_calamo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ItemCajerosBinding
import com.example.banco_calamo.entities.CajeroEntity

class AdapterCajero(private val listaCajero: ArrayList<CajeroEntity>, private var listener: OnClickCajeroListener) : RecyclerView.Adapter<AdapterCajero.ViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCajero.ViewHolder {
      context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_cajeros, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterCajero.ViewHolder, position: Int) {
        val cajero = listaCajero.get(position)
        with(holder) {
            binding.txtNumCajero.text = "ATM ${cajero.id}"
            binding.txtDireccionCajero.text = "${cajero.direccion}"
            binding.imgCajeroBanco.setImageResource(R.drawable.ic_bank)
        }
    }

    override fun getItemCount(): Int = listaCajero.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCajerosBinding.bind(view)

        fun setListener(cajeroEntity: CajeroEntity) {
            binding.root.setOnClickListener {
                listener.onCLick(cajeroEntity)
            }
        }
    }


}