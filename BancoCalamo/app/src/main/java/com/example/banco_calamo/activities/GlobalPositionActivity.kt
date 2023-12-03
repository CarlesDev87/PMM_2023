package com.example.banco_calamo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.R
import com.example.banco_calamo.fragments.AccountsListener
import com.example.banco_calamo.adapters.AdapterCuentas
import com.example.banco_calamo.bd.MiBD
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.ActivityGlobalPositionBinding
import com.example.banco_calamo.databinding.FragmentAccountsBinding
import com.example.banco_calamo.fragments.AccountsFragment
import com.example.banco_calamo.fragments.AccountsMovementsFragment
import com.example.banco_calamo.fragments.MovementsListener
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta
import com.example.banco_calamo.pojo.Movimiento


class GlobalPositionActivity : AppCompatActivity(), AccountsListener, MovementsListener {

    private lateinit var binding: ActivityGlobalPositionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityGlobalPositionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clienteLogueado = intent.getSerializableExtra("Cliente")

        val frgAccounts: AccountsFragment = AccountsFragment.newInstance(clienteLogueado as Cliente)
        frgAccounts.setAccountsListener(this)


        supportFragmentManager.beginTransaction()
            .add(R.id.frg_accounts, frgAccounts).commit()



    }

    override fun onCuentaSeleccionada(cuenta: Cuenta) {
        val frgMovements = AccountsMovementsFragment.newInstance(cuenta)

        if (resources.configuration.screenLayout == 268435796) {

            supportFragmentManager.beginTransaction()
                .replace(R.id.frg_movements, frgMovements).commit()
            frgMovements.setMovementsListener(this)



        } else {
            val intent = Intent(this, GlobalPositionDetailsActivity::class.java)
            intent.putExtra("Cuenta", cuenta)
            startActivity(intent)
        }
    }

    override fun onMovimientoSeleccionado(mov: Movimiento) {
        Toast.makeText(this, mov.getDescripcion(), Toast.LENGTH_SHORT).show()
    }


}


