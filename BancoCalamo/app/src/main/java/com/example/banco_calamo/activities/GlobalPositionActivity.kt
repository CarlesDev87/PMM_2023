package com.example.banco_calamo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.R
import com.example.banco_calamo.fragments.AccountsListener
import com.example.banco_calamo.adapters.AdapterCuentas
import com.example.banco_calamo.bd.MiBD
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.ActivityGlobalPositionBinding
import com.example.banco_calamo.databinding.FragmentAccountsBinding
import com.example.banco_calamo.fragments.AccountsFragment
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta

class GlobalPositionActivity : AppCompatActivity(), AccountsListener {


    private lateinit var binding: ActivityGlobalPositionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGlobalPositionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val cliente = intent.getSerializableExtra("Cliente")

        var frgAccounts: AccountsFragment = AccountsFragment.newInstance(cliente as Cliente)

        frgAccounts.setAccountsListener(this)


    }

    override fun onCuentaSeleccionada(cuenta: Cuenta) {
        if (cuenta != null) {
            var hayDetalle=
                binding.frgAccounts?.let { supportFragmentManager.findFragmentById(it.id) } != null
        }
    }


}


