package com.example.evaluacioncontinua03.data.repository

import com.example.evaluacioncontinua03.data.PersonajeServiceResult
import com.example.evaluacioncontinua03.data.PersonajeServiceResult.*
import com.example.evaluacioncontinua03.data.db.PersonajeDao
import com.example.evaluacioncontinua03.data.db.PersonajeDatabase
import kotlinx.coroutines.flow.collect
import com.example.evaluacioncontinua03.data.response.ListPersonajeResponse
import com.example.evaluacioncontinua03.data.retrofit.RetrofitHelper
import com.example.evaluacioncontinua03.model.NuevoPersonaje
import com.example.evaluacioncontinua03.model.Personaje
import com.example.evaluacioncontinua03.model.toPersonaje
import com.example.evaluacioncontinua03.model.toPersonajeEntity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class PersonajeRepository(val db : PersonajeDatabase? = null) {
    private val dao: PersonajeDao? = db?.personajeDao()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    suspend fun obtenerPersonaje(): PersonajeServiceResult<List<Personaje>> {
        return try {
            val response = RetrofitHelper.webService.obtenerPersonajes()
            if (response.isSuccessful) {
                val listPersonajeResponse = response.body()
                listPersonajeResponse?.let {
                    Success(it)
                } ?: Error(Exception("Respuesta nula de la API"))
            } else {
                Error(Exception("Error en la respuesta de la API"))
            }
        } catch (e: Exception) {
            Error(e)
        }
    }

    suspend fun getFavorites(): List<Personaje> {
        dao?.let {
            val data = dao.getFavorites()
            val personajes : MutableList<Personaje> = mutableListOf()
            for (personajeEntity in data) {
                personajes.add(personajeEntity.toPersonaje())
            }
            return personajes
        } ?: kotlin.run {
            return listOf()
        }
    }

    suspend fun addPersonajeToFavorites(personaje : Personaje) {
        dao?.let {
            dao.addPersonajeToFavorite(personaje.toPersonajeEntity())
        }
    }

    suspend fun getNuevoFromFirestore(): List<NuevoPersonaje> {
        val personajes: MutableList<NuevoPersonaje> = mutableListOf()
        val querySnapshot = firestore.collection("personaje")
            .get()
            .await()

        for (document in querySnapshot.documents) {
            val personaje = document.toObject(NuevoPersonaje::class.java)
            personaje?.let {
                personajes.add(it)
            }
        }

        return personajes
    }


    suspend fun agregarPersonajeNuevo(personaje: NuevoPersonaje): Boolean {
        val personajeData = hashMapOf(
            "frase" to personaje.frase,
            "personaje" to personaje.personaje,
            "por" to personaje.por,
            "imagen" to personaje.imagen,
            "isFavorite" to personaje.isFavorite
        )

        return try {
            firestore.collection("personaje")
                .add(personajeData)
                .await()
            true // Éxito al agregar el personaje
        } catch (e: Exception) {
            false // Error al agregar el personaje
        }
    }
}