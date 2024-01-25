package com.example.t9a1_lagardera_carles.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.t9a1_lagardera_carles.entities.LavadoCoche

@Dao
interface LavadoDAO {

    @Query("SELECT * FROM lavados")
    fun getAllLavados() : MutableList<LavadoCoche>

    @Query("SELECT * FROM lavados WHERE id = :id")
    fun getLavadoById(id: Long): LavadoCoche

    @Insert
    fun insertAll(lavadoCocheList : List<LavadoCoche>)

    @Insert
    fun addLavado(lavadoCoche: LavadoCoche) : Long

    @Update
    fun updateLavado(lavadoCoche: LavadoCoche)

    @Delete
    fun deleteLavado(lavadoCoche: LavadoCoche)

}