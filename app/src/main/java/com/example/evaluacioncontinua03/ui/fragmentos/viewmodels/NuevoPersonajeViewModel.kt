package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacioncontinua03.data.repository.PersonajeRepository
import com.example.evaluacioncontinua03.model.NuevoPersonaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NuevoPersonajeViewModel : ViewModel() {

    private var _listaNuevos = MutableLiveData<List<NuevoPersonaje>>()
    val listaNuevos: LiveData<List<NuevoPersonaje>> get() = _listaNuevos

    private val repository = PersonajeRepository()

    // Función para obtener los personajes favoritos desde Firestore
    fun obtenerNuevosPersonajes() {
        viewModelScope.launch(Dispatchers.IO) {
            val nuevospersonajes = repository.getNuevoFromFirestore() // Cambia esto por la función adecuada de tu repositorio
            withContext(Dispatchers.Main) {
                _listaNuevos.value = nuevospersonajes
            }
        }
    }

    // Función para agregar un nuevo personaje favorito a Firestore
    fun agregarNuevoPersonaje(nuevopersonaje: NuevoPersonaje) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.agregarPersonajeNuevo(nuevopersonaje) // Cambia esto por la función adecuada de tu repositorio
        }
    }
}
