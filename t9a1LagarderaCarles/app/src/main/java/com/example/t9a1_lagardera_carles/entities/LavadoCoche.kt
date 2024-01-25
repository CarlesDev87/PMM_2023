package com.example.t9a1_lagardera_carles.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.t9a1_lagardera_carles.R

@Entity(tableName = "lavados")
data class LavadoCoche(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var marca: String,
    var modelo: String,
    var direccion: String,
    @ColumnInfo(name = "me_gusta")var meGusta: Boolean = false

) {


}