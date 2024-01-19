package com.example.t9a1_lagardera_carles.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.t9a1_lagardera_carles.dao.LavadoDAO
import com.example.t9a1_lagardera_carles.entities.LavadoCoche

@Database(entities = arrayOf(LavadoCoche::class), version = 1)
abstract class LavadoDatabase : RoomDatabase() {

    abstract fun lavadoDao(): LavadoDAO
}