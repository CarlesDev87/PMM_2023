package com.example.banco_calamo.bd

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.banco_calamo.dao.CajeroDAO
import com.example.banco_calamo.entities.CajeroEntity

@Database(entities = [CajeroEntity::class], version = 1)
abstract class CajeroDatabase: RoomDatabase() {
    abstract fun cajeroDao(): CajeroDAO

}