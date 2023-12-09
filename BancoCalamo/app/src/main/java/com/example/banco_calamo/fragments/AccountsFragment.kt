package com.example.banco_calamo.fragments

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.R
import com.example.banco_calamo.adapters.AdapterCuentas
import com.example.banco_calamo.bd.MiBD
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.FragmentAccountsBinding
import com.example.banco_calamo.pojo.Cliente
import com.example.banco_calamo.pojo.Cuenta
import kotlin.math.log


private const val ARG_CLIENTE = "Cliente"


class AccountsFragment : Fragment(), com.example.banco_calamo.adapters.OnClickListener {

    private lateinit var adapterCuentas: AdapterCuentas
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: FragmentAccountsBinding
    private lateinit var listener: AccountsListener
    private lateinit var cliente: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cliente = it.getSerializable(ARG_CLIENTE) as Cliente
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountsBinding.inflate(inflater, container, false)

        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(context)

        val listaCuentas: ArrayList<Cuenta>? = mbo?.getCuentas(cliente as Cliente?) as ArrayList<Cuenta>?

        if (listaCuentas != null) {
            adapterCuentas = AdapterCuentas(listaCuentas, this)
        }

        linearLayoutManager = LinearLayoutManager(context)


        binding.recyclerViewCuentas.apply {
            layoutManager = linearLayoutManager
            adapter = adapterCuentas

        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(c: Cliente) =
            AccountsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CLIENTE, c)
                }
            }
    }

    fun setAccountsListener(listener: AccountsListener) {
        this.listener = listener
    }

    override fun onclick(c: Cuenta) {
        Log.i("accountsFragment", "infoFragment cuentas")
        if (listener != null) {
            listener.onCuentaSeleccionada(c)

        }
    }


}