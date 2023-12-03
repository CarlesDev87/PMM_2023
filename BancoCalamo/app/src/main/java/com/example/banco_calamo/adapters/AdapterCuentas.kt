package com.example.banco_calamo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ItemCuentaBinding
import com.example.banco_calamo.pojo.Cuenta

class AdapterCuentas(private val accountList: ArrayList<Cuenta>, private val listener:OnClickListener) :
    RecyclerView.Adapter<AdapterCuentas.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemCuentaBinding.bind(view)
        fun setListener(cuenta: Cuenta) {
            binding.root.setOnClickListener {
                listener.onclick(cuenta)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_cuenta, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = accountList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cuenta = accountList[position]
        with(holder) {
            binding.txtNumCuenta.text = "${cuenta.getBanco().toString()} - ${cuenta.getSucursal().toString()} - ${cuenta.getDc().toString()} - ${cuenta.getNumeroCuenta().toString()}"

            binding.txtImporteCuenta.text = cuenta.getSaldoActual().toString()
            setListener(cuenta)

            val saldo: Float? = cuenta.getSaldoActual()

            if (saldo != null) {
                if (saldo < 0f) {
                    binding.txtImporteCuenta.setTextColor(ContextCompat.getColor(context, R.color.boton_rojo))
                } else if (saldo > 0f  && saldo < 10000f){
                    binding.txtImporteCuenta.setTextColor(ContextCompat.getColor(context, R.color.blue_dark))
                } else if (saldo > 10000f){
                    binding.txtImporteCuenta.setTextColor(ContextCompat.getColor(context, R.color.green))
                }
            }

            binding.imgCuentaBanco.setImageResource(R.drawable.ic_bank)
            }


        }


    }






