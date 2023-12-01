package com.example.banco_calamo.fragments

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
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


private const val ARG_CLIENTE = "Cliente"


class AccountsFragment : Fragment(), OnClickListener {

    private lateinit var adapterCuentas: AdapterCuentas
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: FragmentAccountsBinding
    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var listener: AccountsListener

    private lateinit var cliente: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cliente = it.getSerializable(ARG_CLIENTE) as Cliente
        }
    }

    fun setAccountsListener(listener: AccountsListener) {
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountsBinding.inflate(inflater, container, false)

        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(context)
        val listaCuentas: ArrayList<Cuenta> = mbo?.getCuentas(cliente) as ArrayList<Cuenta>

        adapterCuentas = AdapterCuentas(listaCuentas)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.recyclerViewCuentas.apply {
            layoutManager = linearLayoutManager
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

    override fun onClick(dialog: DialogInterface?, which: Int) {

    }
}