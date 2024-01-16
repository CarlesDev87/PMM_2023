package com.example.banco_calamo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityAtmManagementBinding
import com.example.banco_calamo.entities.CajeroEntity

class AtmManagementActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAtmManagementBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAtmManagementBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}
