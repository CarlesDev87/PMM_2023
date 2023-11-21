package com.example.banco_calamo.activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ItemMovimientosBinding
import com.example.banco_calamo.pojo.Movimiento

class AdapterMovimientos(private val listaMovimientos: ArrayList<Movimiento>) :
    RecyclerView.Adapter<AdapterMovimientos.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMovimientosBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_movimientos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaMovimientos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movimiento = listaMovimientos.get(position)
        with(holder.binding) {

            txtNumMovimiento.text = "${movimiento.getDescripcion().toString()}"
            txtConceptoMovimiento.text = "${
                movimiento.getFechaOperacion().toString()
            } " + "Importe: -" + "${movimiento.getImporte()}"


            txtConceptoMovimiento.setTextColor(
                ContextCompat.getColor(
                    context,
                    R.color.boton_rojo
                )
            )


        }
    }


}