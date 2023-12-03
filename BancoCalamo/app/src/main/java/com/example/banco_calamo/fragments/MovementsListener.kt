package com.example.banco_calamo.fragments

import com.example.banco_calamo.pojo.Movimiento

interface MovementsListener {
    fun onMovimientoSeleccionado(mov : Movimiento)
}