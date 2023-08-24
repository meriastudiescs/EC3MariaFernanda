package com.example.evaluacioncontinua03.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy
import androidx.room.Query;
import com.example.evaluacioncontinua03.model.PersonajeEntity;
import kotlinx.coroutines.flow.Flow;

@Dao
interface PersonajeDao {

    @Query("Select * from personaje")
    fun getFavorites(): List<PersonajeEntity> // Use Flow for asynchronous data retrieval

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPersonajeToFavorite(personaje: PersonajeEntity)
}
