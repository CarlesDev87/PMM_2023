package com.example.banco_calamo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.bd.MiBD
import com.example.banco_calamo.databinding.ActivityGlobalPositionBinding
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta

class GlobalPositionActivity: AppCompatActivity() {

    private val miBD: MiBD? = null

    private lateinit var binding: ActivityGlobalPositionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGlobalPositionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cuentasCliente = intent.getSerializableExtra("Cliente") as Cliente

        binding.getCuentas(cuentasCliente)


        //hay que vincular las cuentas del cliente por el idcliente


    }

    fun getCuentas(c: Cliente?): ArrayList<*>? {
        return miBD?.cuentaDAO?.getCuentas(c)
    }
}


