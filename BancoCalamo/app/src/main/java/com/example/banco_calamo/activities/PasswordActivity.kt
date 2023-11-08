package com.example.banco_calamo.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityChangePasswdBinding

class PasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChangePasswdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfirmPass.setOnClickListener {

            val newPass = binding.tieNewPass.text.toString()
            val repeatPass = binding.tieRepeatPass.text.toString()

            if (newPass == repeatPass) {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                binding.tiNewpass.setError(getString(R.string.new_pass))
                binding.tiConfirmPasswd.setError(getString(R.string.new_pass))

            }
        }


    }


}


