package com.example.banco_calamo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_calamo.databinding.ActivityTransferBinding

class TransferActivity: AppCompatActivity() {

    private lateinit var binding: ActivityTransferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}