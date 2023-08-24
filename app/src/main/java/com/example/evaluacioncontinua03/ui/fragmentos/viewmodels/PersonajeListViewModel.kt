package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacioncontinua03.data.PersonajeServiceResult
import com.example.evaluacioncontinua03.data.repository.PersonajeRepository
import com.example.evaluacioncontinua03.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonajeListViewModel: ViewModel() {
        private val _personajes : MutableLiveData<List<Personaje>> = MutableLiveData<List<Personaje>>()
    val personajes: LiveData<List<Personaje>> = _personajes

    private val repository = PersonajeRepository()


    fun getPersonajesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.obtenerPersonaje()
            when (response) {
                is PersonajeServiceResult.Success -> {
                    _personajes.postValue(response.data)
                }
                is PersonajeServiceResult.Error -> {
                    // Manejar el error de alguna manera
                }
            }
        }
    }


}