package com.example.banco_calamo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.bd.MiBD
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.ActivityGlobalPositionBinding
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta

class GlobalPositionActivity: AppCompatActivity() {

    private val miBD: MiBD? = null
    private lateinit var adapterCuentas : AdapterCuentas
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityGlobalPositionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGlobalPositionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)
        val cliente = intent.getSerializableExtra("Cliente") as Cliente
        val listaCuentas: ArrayList<Cuenta> = mbo?.getCuentas(cliente) as ArrayList<Cuenta>




        adapterCuentas = AdapterCuentas(listaCuentas)
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerViewCuentas.apply {
            layoutManager = linearLayoutManager
            adapter = adapterCuentas
        }

    }


}


