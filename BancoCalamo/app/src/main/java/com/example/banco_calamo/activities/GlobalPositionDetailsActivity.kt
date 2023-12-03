package com.example.banco_calamo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityGlobalPositionDetailsBinding

import com.example.banco_calamo.fragments.AccountsMovementsFragment
import com.example.banco_calamo.pojo.Cuenta

class GlobalPositionDetailsActivity : AppCompatActivity() {

    //PASAMOS LA CUENTA Y EL FRAGMENT DE MOVIMIENTOS CON EL NEW INSTANCE

    private lateinit var binding : ActivityGlobalPositionDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlobalPositionDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cuentaCliente = intent.getSerializableExtra("Cuenta")

        var frgMovements : AccountsMovementsFragment = AccountsMovementsFragment.newInstance(cuentaCliente as Cuenta)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_accounts_container, frgMovements).commit()

    }


}