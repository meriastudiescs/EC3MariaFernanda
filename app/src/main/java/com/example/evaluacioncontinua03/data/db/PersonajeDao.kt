package com.example.evaluacioncontinua03.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.evaluacioncontinua03.model.Personaje
import com.example.evaluacioncontinua03.model.PersonajeEntity

@Dao
interface FinalDao {
    @Insert
    suspend fun addPersonajeToFavorite(personaje: Personaje)

    @Query("Select * from personaje")
    suspend fun getFavorites() : List<PersonajeEntity>
}