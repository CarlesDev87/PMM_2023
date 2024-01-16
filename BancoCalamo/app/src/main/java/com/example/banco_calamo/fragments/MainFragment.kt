package com.example.banco_calamo.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.banco_calamo.R
import com.example.banco_calamo.activities.AtmListActivity
import com.example.banco_calamo.activities.AtmManagementActivity
import com.example.banco_calamo.activities.GlobalPositionActivity
import com.example.banco_calamo.activities.MovementsActivity
import com.example.banco_calamo.activities.PasswordActivity
import com.example.banco_calamo.activities.TransferActivity
import com.example.banco_calamo.bd.MiBD
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.FragmentMainBinding
import com.example.banco_calamo.pojo.Cliente
import java.io.Serializable


private const val ARG_CLIENTE = "cliente"

class MainFragment : Fragment() {


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


            val clienteLogueado: Cliente = cliente
            binding.dniUser.text = clienteLogueado.getNombre().toString()




       // val clienteLogueado = cliente.getNombre() + " " + cliente.getApellidos()

       // binding.dniUser.text = cliente

        binding.primerBoton.setOnClickListener {
            val intent = Intent(this.context, GlobalPositionActivity::class.java)
            intent.putExtra("Cliente", cliente)
            startActivity(intent)
        }

        binding.segundoBoton.setOnClickListener {
            val intent = Intent(this.context, MovementsActivity::class.java)
            intent.putExtra("Cliente", cliente)
            startActivity(intent)
        }

        binding.tercerBoton.setOnClickListener {
            val intent = Intent(this.context, TransferActivity::class.java)
            startActivity(intent)
        }

        binding.cuartoBoton.setOnClickListener {
            val intent = Intent(this.context, PasswordActivity::class.java)
            startActivity(intent)
        }

        binding.sextoBoton.setOnClickListener {
            val intent = Intent(this.context, AtmManagementActivity::class.java)
            startActivity(intent)
        }

        binding.septBoton.setOnClickListener {
            System.exit(0)
        }

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(c: Serializable?) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CLIENTE, c)
                }
            }
    }
}
