package com.example.banco_calamo.activities

import android.os.Bundle
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
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta

class GlobalPositionActivity : AppCompatActivity(), AccountsListener {


    private lateinit var binding: ActivityGlobalPositionBinding

    private lateinit var frgMovements: AccountsMovementsFragment
    private lateinit var fragmentAccounts: AccountsFragment

    private lateinit var activeFragment : Fragment

    private lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityGlobalPositionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val clienteLogueado = intent.getSerializableExtra("Cliente")

        var frgAccounts: AccountsFragment = AccountsFragment.newInstance(clienteLogueado as Cliente)
        frgAccounts.setAccountsListener(this)

        fragmentManager = supportFragmentManager
        fragmentAccounts = AccountsFragment()
        frgMovements = AccountsMovementsFragment()
        activeFragment = fragmentAccounts

        fragmentManager.beginTransaction()
            .add(R.id.frg_accounts_container, fragmentAccounts, AccountsFragment::class.java.name)
            .hide(frgMovements).commit()
        fragmentManager.beginTransaction()
            .add(R.id.frg_accounts_container, frgMovements, AccountsMovementsFragment::class.java.name)
            .hide(fragmentAccounts).commit()


    }

    override fun onCuentaSeleccionada(cuenta: Cuenta) {

        if (cuenta != null) {

            fragmentManager.beginTransaction().hide(activeFragment).show(frgMovements).commit()
            activeFragment = frgMovements

        }
    }


}


