package com.example.banco_calamo.activities


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.banco_calamo.R
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.ActivityGlobalPositionDetailsBinding
import com.example.banco_calamo.fragments.AccountsMovementsFragment
import com.example.banco_calamo.fragments.MovementsListener
import com.example.banco_calamo.pojo.Cuenta
import com.example.banco_calamo.pojo.Movimiento
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GlobalPositionDetailsActivity : AppCompatActivity(), MovementsListener {

    //PASAMOS LA CUENTA Y EL FRAGMENT DE MOVIMIENTOS CON EL NEW INSTANCE

    private lateinit var binding: ActivityGlobalPositionDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlobalPositionDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cuentaCliente = intent.getSerializableExtra("Cuenta")


        var frgMovements: AccountsMovementsFragment =
            AccountsMovementsFragment.newInstance(cuentaCliente as Cuenta)
        frgMovements.setMovementsListener(this)

        var frgMovementsTipo: AccountsMovementsFragment =
            AccountsMovementsFragment.newInstance(cuentaCliente, 0)
        var frgMovementsTipo1: AccountsMovementsFragment =
            AccountsMovementsFragment.newInstance(cuentaCliente, 1)
        var frgMovementsTipo2: AccountsMovementsFragment =
            AccountsMovementsFragment.newInstance(cuentaCliente, 2)




        supportFragmentManager.beginTransaction()
            .add(R.id.frg_movements, frgMovements)


        binding.bottomNavigation.setOnNavigationItemSelectedListener {
                it.isChecked = true
                when (it.itemId) {
                    R.id.navigation_home -> {
                        replaceFragment(frgMovements)
                    }

                    R.id.navigation_tipo_0 -> {
                        replaceFragment(frgMovementsTipo)
                    }

                    R.id.navigation_tipo_1 -> {
                        replaceFragment(frgMovementsTipo1)
                    }

                    R.id.navigation_tipo_2 -> {
                        replaceFragment(frgMovementsTipo2)
                    }
                }
            false
            }


    }


    override fun onMovimientoSeleccionado(mov: Movimiento) {

        val dialogView = layoutInflater.inflate(R.layout.dialog_movement, null)
        val idMovimiento = dialogView.findViewById<TextView>(R.id.textView1)

        idMovimiento.text = mov.toString()

        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.txt_dialogo)
            .setView(dialogView)
            .setPositiveButton(R.string.txt_btn_dialogo) { dialog, i ->
                dialog.dismiss()
            }
            .show()

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frg_movements, fragment).commit()
    }


}
