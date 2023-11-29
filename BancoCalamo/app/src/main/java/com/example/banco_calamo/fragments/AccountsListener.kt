package com.example.banco_calamo.fragments

import com.example.banco_calamo.pojo.Cuenta

interface AccountsListener {
    fun onCuentaSeleccionada(c: Cuenta)
}