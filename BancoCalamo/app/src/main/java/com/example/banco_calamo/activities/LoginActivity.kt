package com.example.banco_calamo.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnEnter.setOnClickListener {
            val dniUser = binding.editTextUser.text.toString()
            if (dniValido(dniUser)) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("dni", dniUser)
                startActivity(intent)

            } else {
                binding.textInputUser.setError(getString(R.string.ti_user))
            }
        }
        
        binding.editTextUser.onFocusChangeListener = View.OnFocusChangeListener() { v, hasFocus ->
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

        binding.btnExit.setOnClickListener {
            System.exit(0)
        }
    }

    private fun dniValido(dni: String): Boolean {
        val regexDNI = Regex("^\\d{8}[A-HJ-NP-TV-Z]\$")

        return regexDNI.matches(dni)
    }
}
