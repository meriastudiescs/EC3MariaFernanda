package com.dylan.anotafacil.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dylan.anotafacil.data.db.NotaDatabase
import com.dylan.anotafacil.data.repository.NoteRepository
import com.dylan.anotafacil.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteFavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : NoteRepository
    private var _favorites : MutableLiveData<List<Note>> = MutableLiveData()
    var favorites : LiveData<List<Note>> = _favorites

    init {
        val db = NotaDatabase.getDatabase(application)
        repository = NoteRepository(db)
    }

    fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getFavorites()
            _favorites.postValue(data)
        }
    }

}