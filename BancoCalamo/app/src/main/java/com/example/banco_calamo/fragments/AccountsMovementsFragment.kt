package com.example.banco_calamo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.banco_calamo.R
import com.example.banco_calamo.pojo.Cuenta

private const val ARG_CUENTA = "Cuenta"
class AccountsMovementsFragment : Fragment()  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accounts_movements, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(c: Cuenta) =
            AccountsMovementsFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CUENTA, c)
                }
            }
    }
}