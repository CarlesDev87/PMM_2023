package com.example.banco_calamo.activities

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.ActivityMovementsBinding
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta
import com.example.banco_calamo.pojo.Movimiento

class MovementsActivity: AppCompatActivity() {

    private lateinit var adapterMovimientos: AdapterMovimientos
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMovementsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovementsBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)
        val cliente = intent.getSerializableExtra("Cliente") as Cliente
        val cuenta = intent.getSerializableExtra("Cuenta") as Cuenta
        val listaMovimientos: ArrayList<Movimiento> = mbo?.getMovimientos(cuenta) as ArrayList<Movimiento>
        val listaCuentas: ArrayList<Cuenta> = mbo?.getCuentas(cliente) as ArrayList<Cuenta>


        val adapterCuentas = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaCuentas)
        val spinner = binding.spinnerCuentaMovimientos

        adapterCuentas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapterCuentas


        adapterMovimientos = AdapterMovimientos(listaMovimientos)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerViewMovimientos.apply {
            adapter = adapterMovimientos
            layoutManager = linearLayoutManager
        }




        }

    }
