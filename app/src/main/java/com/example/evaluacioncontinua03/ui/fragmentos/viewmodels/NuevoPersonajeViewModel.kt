package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluacioncontinua03.data.repository.PersonajeRepository
import com.example.evaluacioncontinua03.data.retrofit.RetrofitHelper
import com.example.evaluacioncontinua03.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private var _listaPersonajes = MutableLiveData<List<Personaje>>()
    val listaPersonajes: LiveData<List<Personaje>> get() = _listaPersonajes

    private val repository = PersonajeRepository()

    fun obtenerPersonajes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitHelper.webService.obtenerPersonajes()
            withContext(Dispatchers.Main) {
                Log.d("API", response.body().toString())
                _listaPersonajes.value = response.body()
            }
        }
    }

    fun obtenerPersonaje(personaje: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitHelper.webService.obtenerPersonaje(personaje)
            withContext(Dispatchers.Main) {
                Log.d("API", response.body().toString())
                _listaPersonajes.value = response.body()
            }
        }
    }



}