package com.example.banco_calamo.activities

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityTransferBinding
import com.google.android.material.snackbar.Snackbar

class TransferActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransferBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //SPINNER CUENTAS Y SU ADAPTER

        val cuentas = arrayOf(
            "ES00-1234-8876-00-1234567890",
            "ES01-9876-8765-45-2162537869",
            "ES02-1234-9876-09-8564738295",
            "ES03-6926-5761-14-9165824864"
        )
        val adapterOwnAccount = ArrayAdapter(this, android.R.layout.simple_spinner_item, cuentas)
        val spinner = binding.spinnerCuentas
        adapterOwnAccount.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapterOwnAccount

        //SPINNER CUENTAS SELECCIONADAS EN CUENTAS PROPIAS

        val spinnerCuentaSelecc = binding.spinnerCuentaSelecc
        val adapterCuentaSelecc = adapterOwnAccount
        adapterCuentaSelecc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCuentaSelecc.adapter = adapterCuentaSelecc

        //SPINNER DIVISAS

        val moneda = arrayOf("$", "€")
        val adapterCantidad = ArrayAdapter(this, android.R.layout.simple_spinner_item, moneda)
        val spinnerCantidad = binding.spinnerCantidad
        spinnerCantidad.adapter = adapterCantidad

        binding.rButton1.setOnCheckedChangeListener { rb1, isChecked ->
            if (isChecked) {
                binding.spinnerCuentaSelecc.visibility = View.VISIBLE
            } else {
                binding.spinnerCuentaSelecc.visibility = View.GONE
            }

        }

        binding.rButton2.setOnCheckedChangeListener { rb2, isChecked ->
            if (isChecked) {
                binding.textInputOtherAccount.visibility = View.VISIBLE
            } else {
                binding.textInputOtherAccount.visibility = View.GONE
            }

        }

        binding.btnEnviarTransferencia.setOnClickListener {
            // Obtener los valores seleccionados
            val cuentaSeleccionada = binding.spinnerCuentas.selectedItem.toString()
            val cuentaDestino = if (binding.rButton1.isChecked) {
                // Si RadioButton 1 está seleccionado, obtener la cuenta del Spinner
                binding.spinnerCuentaSelecc.selectedItem.toString()


            } else {
                // Si RadioButton 2 está seleccionado, obtener la cuenta del EditText
                binding.textInputOtherAccount.text.toString()
            }
            val cantidadTransferencia = binding.etxtCantidad.text.toString()
            val divisaSeleccionada = binding.spinnerCantidad.selectedItem.toString()
            val justificante = if (binding.chkJustificante.isChecked) {
                binding.chkJustificante.text.toString()
            } else {
                ""
            }
            val cuentaNueva = binding.textInputOtherAccount.text.toString()


            // Construir el mensaje para el Snackbar


            if (binding.rButton1.isChecked) {
                val mensaje = getString(R.string.cuenta_origen) + "\n" + "$cuentaSeleccionada\n" +
                        getString(R.string.cuenta_destino) + ":\n$cuentaDestino\n" +
                        getString(R.string.txt_cantidad) + ": $cantidadTransferencia $divisaSeleccionada\n" +
                        "$justificante"
                val snackbar = Snackbar.make(binding.root, mensaje, Snackbar.ANIMATION_MODE_SLIDE)
                snackbar.setTextMaxLines(6)
                snackbar.show()
                val snackbarView = snackbar.view
                val textView =
                    snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                textView.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_texto_boton
                    )
                )
            } else {
                ""
            }
            if (binding.rButton2.isChecked) {
                val mensaje = getString(R.string.cuenta_origen) + "\n" + "$cuentaSeleccionada\n" +
                        getString(R.string.cuenta_ajena) + ":\n$cuentaDestino\n" +
                        getString(R.string.txt_cantidad) + ": $cantidadTransferencia $divisaSeleccionada\n" +
                        "$justificante"
                val snackbar = Snackbar.make(binding.root, mensaje, Snackbar.ANIMATION_MODE_SLIDE)
                snackbar.setTextMaxLines(6)
                snackbar.show()
                val snackbarView = snackbar.view
                val textView =
                    snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
                textView.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.color_texto_boton
                    )
                )

            } else {
                ""
            }


        }

        binding.btnCancelarTransferencia.setOnClickListener {
            // Borrar toda la información introducida
            binding.spinnerCuentas.setSelection(0)  // Establecer la selección del Spinner a la primera posición
            binding.spinnerCuentaSelecc.setSelection(0)
            binding.spinnerCantidad.setSelection(0)
            binding.rButton1.isChecked = true  // Seleccionar RadioButton1 por defecto
            binding.textInputOtherAccount.text = null  // Borrar el texto del EditText
            binding.etxtCantidad.text = null
            binding.chkJustificante.isChecked = false  // Desmarcar el CheckBox
        }

    }


}
