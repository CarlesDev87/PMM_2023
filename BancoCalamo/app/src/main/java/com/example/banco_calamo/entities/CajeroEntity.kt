package com.example.banco_calamo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cajeros")
data class CajeroEntity(

    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo val direccion: String,
    @ColumnInfo val latitud: Double,
    @ColumnInfo val longitud: Double,
    @ColumnInfo val zoom: String

)