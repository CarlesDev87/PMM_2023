package com.example.banco_calamo.activities

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.adapters.AdapterMovimientos
import com.example.banco_calamo.bd.MiBancoOperacional

import com.example.banco_calamo.databinding.FragmentAccountsMovementsBinding
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta
import com.example.banco_calamo.pojo.Movimiento

class MovementsActivity: AppCompatActivity() {

    private lateinit var adapterMovimientos: AdapterMovimientos
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: FragmentAccountsMovementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentAccountsMovementsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)
        val cliente = intent.getSerializableExtra("Cliente") as Cliente
        val listaCuentas: ArrayList<Cuenta> = mbo?.getCuentas(cliente) as ArrayList<Cuenta>


        val adapterCuentas = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCuentas)
        val spinner = binding.spinnerCuentaMovimientos

        adapterCuentas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapterCuentas


        binding.spinnerCuentaMovimientos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val listaMovimientos = mbo?.getMovimientos(listaCuentas.get(position)) as ArrayList<Movimiento>
                adapterMovimientos = AdapterMovimientos(listaMovimientos)

                binding.recyclerViewMovimientos.apply {
                    adapter = adapterMovimientos
                    layoutManager = linearLayoutManager

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        linearLayoutManager = LinearLayoutManager(this)






        }

    }
