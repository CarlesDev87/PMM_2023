package com.example.t9a1_lagardera_carles.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t9a1_lagardera_carles.LavadoApplication
import com.example.t9a1_lagardera_carles.adapter.MainAux
import com.example.t9a1_lagardera_carles.R
import com.example.t9a1_lagardera_carles.adapter.LavadoAdapter
import com.example.t9a1_lagardera_carles.adapter.onClickListener
import com.example.t9a1_lagardera_carles.databinding.ActivityMainBinding
import com.example.t9a1_lagardera_carles.entities.LavadoCoche
import com.example.t9a1_lagardera_carles.fragment.EditarLavadoFragment
import java.util.concurrent.LinkedBlockingQueue

class MainActivity : AppCompatActivity(), onClickListener, MainAux {

    private lateinit var binding: ActivityMainBinding
    private lateinit var lAdapter: LavadoAdapter
    private lateinit var linearLayout: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        binding.fab.setOnClickListener {
            launchEditarLavadoFragment()
        }
    }

    private fun launchEditarLavadoFragment() {
        val fragment = EditarLavadoFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.containerMain, fragment)
            .addToBackStack(null)
            .commit()
       // binding.fab.hide()
        hideFab()
    }

    private fun setupRecyclerView() {
        lAdapter = LavadoAdapter(mutableListOf(), this)
        linearLayout = LinearLayoutManager(this)
        getStores()
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayout
            adapter = lAdapter
        }
    }

    fun getStores() {
        val queue = LinkedBlockingQueue<MutableList<LavadoCoche>>()
        Thread{
            val lavado = LavadoApplication.database.lavadoDao().getAllLavados()
            queue.add(lavado)
        }.start()

        lAdapter.setLavados( queue.take())
    }

    override fun onClick(lavadoCoche: LavadoCoche) {

    }

    /**
     *  Este metodo viene de la interfaz MainAux
     */
    override fun hideFab(isVisible: Boolean) {
        if (isVisible) {
            binding.fab.show()
        }
        else {
            binding.fab.hide()
        }
    }
}