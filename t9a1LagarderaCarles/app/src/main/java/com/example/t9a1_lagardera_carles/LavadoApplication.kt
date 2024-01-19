package com.example.t9a1_lagardera_carles

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.t9a1_lagardera_carles.database.LavadoDatabase

class LavadoApplication : Application() {

    companion object {
        lateinit var database: LavadoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, LavadoDatabase::class.java, "LavadoDatabase").build()
    }
}