package com.example.t10a1_lagardera_carles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t10a1_lagardera_carles.databinding.ItemHogwartsBinding
import com.google.gson.annotations.SerializedName

data class HogwartsResponse(
    @SerializedName("name") val nombre: String,
    @SerializedName("species") val especie : String,
    @SerializedName("ancestry") val ancestro: String,
    @SerializedName("patronus") val patrono: String,
    @SerializedName("image") val url: String
) {
}



