package com.dylan.anotafacil.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dylan.anotafacil.data.db.NotaDatabase
import com.dylan.anotafacil.data.repository.NoteRepository
import com.dylan.anotafacil.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteDetailViewModel(application : Application) : AndroidViewModel(application) {
    private val repository : NoteRepository
    init {
        val db = NotaDatabase.getDatabase(application)
        repository = NoteRepository(db)
    }

    fun addFavorites(note : Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addNoteToFavorites(note)
        }
    }

}