package com.example.banco_calamo.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_calamo.R
import com.example.banco_calamo.adapters.AdapterCuentas
import com.example.banco_calamo.adapters.AdapterMovimientos
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.FragmentAccountsBinding
import com.example.banco_calamo.databinding.FragmentAccountsMovementsBinding
import com.example.banco_calamo.pojo.Cuenta
import com.example.banco_calamo.pojo.Movimiento
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private const val ARG_CUENTA = "Cuenta"
private const val ARG_TIPO = "Tipo"
class AccountsMovementsFragment : Fragment(), com.example.banco_calamo.adapters.OnClickListenerMovements  {

    private lateinit var adapterMovimientos: AdapterMovimientos
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: FragmentAccountsMovementsBinding
    private lateinit var cuenta : Cuenta
    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var listener: MovementsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        cuenta = it.getSerializable(ARG_CUENTA) as Cuenta

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentAccountsMovementsBinding.inflate(inflater, container, false)

        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(context)

        val listaMovimientos: ArrayList<Movimiento> = mbo?.getMovimientos(cuenta) as ArrayList<Movimiento>

        adapterMovimientos  = AdapterMovimientos(listaMovimientos, this)
        linearLayoutManager = LinearLayoutManager(context)
        itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        binding.recyclerViewMovimientos.apply {
            layoutManager = linearLayoutManager
            adapter = adapterMovimientos
            addItemDecoration(itemDecoration)

        }


        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(c: Cuenta) =
            AccountsMovementsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CUENTA, c)
                }
            }

        fun newInstance(c: Cuenta, tipo: Int) =
            AccountsMovementsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_TIPO, c)
                    putSerializable(ARG_TIPO, tipo)
                }

            }
    }

    fun setMovementsListener(listener: MovementsListener) {
        this.listener = listener
    }

    override fun onClick(mov: Movimiento) {
        if (listener != null) {
            listener.onMovimientoSeleccionado(mov)
        }
    }


}