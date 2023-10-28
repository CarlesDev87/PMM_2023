package com.example.tema5app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.tema5app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Datos para el Spinner
        val datos = arrayOf("Opción 1", "Opción 2", "Opción 3")

        // Crear un ArrayAdapter usando los datos y un diseño predeterminado
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, datos)

        val spinner = binding.cmbOpciones



        // Especificar el diseño del menú desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)




        // Asignar el ArrayAdapter al Spinner
        spinner.adapter = adapter

        // Manejar la selección de elementos del Spinner
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val seleccion = datos[position]
                binding.lblMensaje.text = "Seleccionado: $seleccion"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Acciones a realizar si no se selecciona nada
                binding.lblMensaje.text = ""
            }
        })
    }
}