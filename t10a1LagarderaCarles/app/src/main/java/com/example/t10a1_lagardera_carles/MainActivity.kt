package com.example.t10a1_lagardera_carles


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t10a1_lagardera_carles.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HogwartsAdapter
    private val hogwartsPersonajes = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = HogwartsAdapter(hogwartsPersonajes)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getCharacters() {

        CoroutineScope(Dispatchers.IO).launch {
            val llamada: Response<HogwartsResponse> = getRetrofit().create(APIService::class.java)
                .getCharacters("https://hp-api.onrender.com/api/characters")
            val personajes: HogwartsResponse? = llamada.body()

            runOnUiThread {

                if (llamada.isSuccessful) {
                    val nombre: String? = personajes?.nombre ?: ""
                    val especie: String? = personajes?.especie ?: ""
                    val ancestro: String? = personajes?.ancestro ?: ""
                    val patronus: String? = personajes?.patrono ?: ""
                    val imagen: String? = personajes?.url ?: ""
                    hogwartsPersonajes.clear()
                    if (nombre != null) {
                        hogwartsPersonajes.addAll(mutableListOf(nombre))
                    }
                    if (especie != null) {
                        hogwartsPersonajes.addAll(mutableListOf(especie))
                    }
                    if (ancestro != null) {
                        hogwartsPersonajes.addAll(mutableListOf(ancestro))
                    }
                    if (patronus != null) {
                        hogwartsPersonajes.addAll(mutableListOf(patronus))
                    }
                    if (imagen != null) {
                        hogwartsPersonajes.addAll(mutableListOf(imagen))
                    }

                    adapter.notifyDataSetChanged()

                } else {
                    showError()
                }
            }
        }
    }


    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

}