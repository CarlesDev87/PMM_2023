package com.example.banco_calamo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ItemMovimientosBinding
import com.example.banco_calamo.fragments.MovementsListener
import com.example.banco_calamo.pojo.Movimiento

class AdapterMovimientos(private val listaMovimientos: ArrayList<Movimiento>, private val listener: OnClickListenerMovements? = null) :
    RecyclerView.Adapter<AdapterMovimientos.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemMovimientosBinding.bind(view)

        fun setListener(mov : Movimiento) {
           binding.root.setOnClickListener {
               listener?.onClick(mov)
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_movimientos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaMovimientos.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movimiento = listaMovimientos.get(position)
        with(holder) {

            binding.imgCuentaMovimiento.setImageResource(R.drawable.dinero)
            binding.txtNumMovimiento.text = "${movimiento.getDescripcion().toString()}"
            binding.txtConceptoMovimiento.text = "${movimiento.getImporte()}"
            setListener(movimiento)


            binding.txtConceptoMovimiento.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.boton_rojo
                )
            )


        }
    }




}