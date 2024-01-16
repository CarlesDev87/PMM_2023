package com.example.banco_calamo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.banco_calamo.R
import com.example.banco_calamo.adapters.AdapterCajero
import com.example.banco_calamo.adapters.OnClickCajeroListener
import com.example.banco_calamo.dao.CajeroDAO
import com.example.banco_calamo.databinding.FragmentAtmListBinding
import com.example.banco_calamo.entities.CajeroEntity

private const val ARG_CAJERO = "cajero"
class AtmListFragment : Fragment(), OnClickCajeroListener  {

private lateinit var cajero: CajeroEntity
private lateinit var binding: FragmentAtmListBinding
private lateinit var adapterCajero: AdapterCajero
private lateinit var cajeroDAO: CajeroDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        cajero = it.getSerializable("cajero") as CajeroEntity
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAtmListBinding.inflate(inflater, container, false)

        val listaCajeros =
        adapterCajero = cajeroDAO.getAllCajeros()

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(cajero: CajeroEntity) =
            AtmListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable()
                }
            }
    }

    override fun onCLick(cajeroEntity: CajeroEntity) {
    }
}