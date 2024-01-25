package com.example.t9a1_lagardera_carles.adapter

import com.example.t9a1_lagardera_carles.entities.LavadoCoche

interface MainAux {
    fun hideFab(isVisible : Boolean = false)

    fun addLavado(lavado: LavadoCoche)
}