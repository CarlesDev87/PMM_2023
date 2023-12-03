package com.example.banco_calamo.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityGlobalPositionDetailsBinding
import com.example.banco_calamo.fragments.AccountsListener

import com.example.banco_calamo.fragments.AccountsMovementsFragment
import com.example.banco_calamo.fragments.MovementsListener
import com.example.banco_calamo.pojo.Cuenta
import com.example.banco_calamo.pojo.Movimiento

class GlobalPositionDetailsActivity : AppCompatActivity(), MovementsListener  {

    //PASAMOS LA CUENTA Y EL FRAGMENT DE MOVIMIENTOS CON EL NEW INSTANCE

    private lateinit var binding : ActivityGlobalPositionDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlobalPositionDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cuentaCliente = intent.getSerializableExtra("Cuenta")

        var frgMovements : AccountsMovementsFragment = AccountsMovementsFragment.newInstance(cuentaCliente as Cuenta)
        frgMovements.setMovementsListener(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.frg_movements, frgMovements).commit()


    }

    override fun onMovimientoSeleccionado(mov: Movimiento) {
        Toast.makeText(this, mov.getDescripcion(), Toast.LENGTH_SHORT).show()
    }


}