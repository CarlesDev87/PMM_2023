package com.example.t9a1_lagardera_carles.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.t9a1_lagardera_carles.LavadoApplication
import com.example.t9a1_lagardera_carles.activities.MainActivity
import com.example.t9a1_lagardera_carles.R
import com.example.t9a1_lagardera_carles.databinding.FragmentEditarLavadoBinding
import com.example.t9a1_lagardera_carles.entities.LavadoCoche
import com.google.android.material.snackbar.Snackbar
import java.util.concurrent.LinkedBlockingQueue



class EditarLavadoFragment : Fragment() {

    private lateinit var binding: FragmentEditarLavadoBinding
    private var mActivity: MainActivity? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditarLavadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mActivity = activity as? MainActivity
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mActivity?.supportActionBar?.title = getString(R.string.titulo_toolbar)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_config, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                requireActivity().onBackPressed()
                true
            }
            R.id.action_config -> {  // GUARDAREMOS LA INFO EN LA BASE DE DATOS

                val lavado = LavadoCoche(marca = binding.tieMarca.text.toString().trim(), modelo = binding.tieModelo.text.toString().trim(), direccion = binding.tieDireccion.text.toString(), meGusta = false)









                val queue = LinkedBlockingQueue<Long>()
                Thread {
                    val id = LavadoApplication.database.lavadoDao().addLavado(lavado)
                    queue.add(id)
                }.start()

                with(queue.take()) {
                    Snackbar.make(binding.root, "Lavado agregado correctamente", Snackbar.LENGTH_SHORT).show()
                }


                true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }


    override fun onDestroy() {
        mActivity?.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        mActivity?.supportActionBar?.title = getString(R.string.app_name)
        mActivity?.hideFab(true)
        setHasOptionsMenu(false)
        super.onDestroy()
    }


}