package com.example.banco_calamo.activities

import android.app.Application
import androidx.room.Room
import com.example.banco_calamo.bd.CajeroDatabase

class CajeroApplication: Application() {

    companion object {
        lateinit var database: CajeroDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, CajeroDatabase::class.java,
            "CajeroDatabase")
            .build()
    }
}