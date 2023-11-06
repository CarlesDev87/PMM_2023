package com.example.banco_calamo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dni = intent.getStringExtra("dni")

        binding.dniUser.text =  dni

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


}