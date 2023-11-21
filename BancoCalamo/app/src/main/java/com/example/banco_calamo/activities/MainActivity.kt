package com.example.banco_calamo.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.databinding.ActivityMainBinding
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.pojo.Cliente


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cliente = intent.getSerializableExtra("Cliente") as Cliente

        login(cliente)

        binding.primerBoton.setOnClickListener {
            intent = Intent(this, GlobalPositionActivity::class.java)
            intent.putExtra("Cliente", cliente)
            startActivity(intent)
        }

        binding.segundoBoton.setOnClickListener {
            intent = Intent(this, MovementsActivity::class.java)
            intent.putExtra("Cliente", cliente)
            startActivity(intent)
        }

        binding.septBoton.setOnClickListener {
            System.exit(0)
        }

        binding.cuartoBoton.setOnClickListener {
            intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent)
        }

        binding.tercerBoton.setOnClickListener {
            intent = Intent(this, TransferActivity::class.java)
            startActivity(intent)
        }


    }

    fun login (c:Cliente):Cliente? {

        binding.dniUser.text = c.getNombre() + " "+ c.getApellidos()

        return c

    }
}