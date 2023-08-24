package com.example.evaluacioncontinua03.ui.fragmentos.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.evaluacioncontinua03.data.db.PersonajeDatabase
import com.example.evaluacioncontinua03.data.repository.PersonajeRepository
import com.example.evaluacioncontinua03.model.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonajeFavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : PersonajeRepository
    private var _favorites : MutableLiveData<List<Personaje>> = MutableLiveData()
    var favorites : LiveData<List<Personaje>> = _favorites

    init {
        val db = PersonajeDatabase.getDatabase(application)
        repository = PersonajeRepository(db)
    }

    fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getFavorites()
            _favorites.postValue(data)
        }
    }

}