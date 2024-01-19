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

    enum class TipoLavado(val precio: Int) {
        ESTANDARD(40),
        DELUXE(70),
        SUPREME(100)
    }

    enum class TipoCoche(val tipo: String, val suplemento: Int, val foto: Int) {
        UTILITARIO("UTILITARIO", 0, R.drawable.utilitario),
        BERLINA("BERLINA", 10, R.drawable.berlina),
        SUV("SUV", 20, R.drawable.suv)
    }
}