package com.example.banco_calamo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.banco_calamo.R
import com.example.banco_calamo.activities.GlobalPositionActivity
import com.example.banco_calamo.activities.MovementsActivity
import com.example.banco_calamo.activities.PasswordActivity
import com.example.banco_calamo.activities.TransferActivity
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.FragmentMainBinding
import com.example.banco_calamo.pojo.Cliente

// TODO: Rename parameter arguments, choose names that match



/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
private const val ARG_CLIENTE = "CLiente"

class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var binding: FragmentMainBinding
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

        binding = FragmentMainBinding.inflate(inflater, container, false)

        val nombreCliente = cliente.getNombre()
        binding.dniUser.text = nombreCliente

        return binding.root
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Main2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(c: Cliente) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CLIENTE, c)
                }
            }
    }
}
