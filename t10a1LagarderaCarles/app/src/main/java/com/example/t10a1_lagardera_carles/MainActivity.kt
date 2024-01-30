package com.example.t10a1_lagardera_carles


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t10a1_lagardera_carles.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HogwartsAdapter
    private val hogwartsPersonajes = mutableListOf<HogwartsResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        getCharacters()

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

            val response: Response<List<HogwartsResponse>> =
                getRetrofit().create(APIService::class.java)
                    .getCharacters(
                        "https://hp-api.onrender.com/api/characters"
                    )

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val personajes: List<HogwartsResponse>? = response.body()

                    if (personajes != null) {
                        hogwartsPersonajes.clear()
                        hogwartsPersonajes.addAll(personajes)
                        adapter.notifyDataSetChanged()
                    } else {
                        showError()

                    }
                }


            }
        }
    }


    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

}


