package com.example.banco_calamo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.banco_calamo.R
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.databinding.ActivityLoginBinding
import com.example.banco_calamo.pojo.Cliente
import java.io.Serializable

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnEnter.setOnClickListener {
            val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)

            // Introducimos los datos como si fuera la pantalla inicial

            var cliente = Cliente()
            cliente.setNif(binding.editTextUser.text.toString())
            cliente.setClaveSeguridad(binding.editTextPass.text.toString())

            val dniUser = cliente.getNif()
            val passUser = cliente.getClaveSeguridad()

            // Logueamos al cliente

            if (!dniUser.isNullOrEmpty() && dniValido(dniUser)) {
                val clienteLogueado = mbo?.login(cliente) ?: -1
                if (clienteLogueado == -1) {
                    Toast.makeText(this, getString(R.string.toast_cliente_noExiste), Toast.LENGTH_LONG).show()
                } else {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("ARG_CLIENTE", clienteLogueado as Serializable)
                    startActivity(intent)
                }


            } else {
                binding.textInputUser.setError(getString(R.string.ti_user))
            }

            /* binding.editTextUser.onFocusChangeListener = View.OnFocusChangeListener() { v, hasFocus ->
                 if (!hasFocus) {
                     val dniUser = binding.editTextUser.text.toString()
                     if (dniValido(dniUser)) {
                         val intent = Intent(this, MainActivity::class.java)
                         intent.putExtra("dni", dniUser)

                     } else {
                         binding.textInputUser.setError(getString(R.string.ti_user))
                     }
                 }
             }

             */

            binding.btnExit.setOnClickListener {
                System.exit(0)
            }
        }


    }
}

private fun dniValido(dni: String): Boolean {
    val regexDNI = Regex("^\\d{8}[A-HJ-NP-TV-Z]\$")

    return regexDNI.matches(dni)
}