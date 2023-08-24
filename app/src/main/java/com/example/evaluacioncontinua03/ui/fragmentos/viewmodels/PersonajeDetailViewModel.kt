package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacioncontinua03.data.db.PersonajeDatabase
import com.example.evaluacioncontinua03.data.repository.PersonajeRepository
import com.example.evaluacioncontinua03.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonajeDetailViewModel(application : Application) : AndroidViewModel(application) {
    private val repository : PersonajeRepository
    init {
        val db = PersonajeDatabase.getDatabase(application)
        repository = PersonajeRepository(db)
    }

    fun addFavorites(personaje : Personaje) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPersonajeToFavorites(personaje)
        }
    }

}